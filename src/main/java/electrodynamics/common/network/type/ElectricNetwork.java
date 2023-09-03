package electrodynamics.common.network.type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import electrodynamics.api.capability.ElectrodynamicsCapabilities;
import electrodynamics.api.capability.types.electrodynamic.ICapabilityElectrodynamic;
import electrodynamics.api.network.cable.type.IConductor;
import electrodynamics.common.block.subtype.SubtypeWire;
import electrodynamics.common.network.NetworkRegistry;
import electrodynamics.prefab.network.AbstractNetwork;
import electrodynamics.prefab.utilities.ElectricityUtils;
import electrodynamics.prefab.utilities.Scheduler;
import electrodynamics.prefab.utilities.object.TransferPack;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ElectricNetwork extends AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack> implements ICapabilityElectrodynamic {
	private double resistance = 0;
	private double energyLoss = 0;
	private double voltage = 0.0;
	private double lastEnergyLoss = 0;
	private double lastVoltage = 0.0;
	private HashSet<BlockEntity> currentProducers = new HashSet<>();
	private double transferBuffer = 0;
	private double maxTransferBuffer = 0;

	private double minimumVoltage = -1.0D;
	private long minimumAmpacity = 0;

	public double getLastEnergyLoss() {
		return lastEnergyLoss;
	}

	@Override
	public double getVoltage() {
		return voltage;
	}

	public double getActiveVoltage() {
		return lastVoltage;
	}

	public double getResistance() {
		return resistance;
	}

	public ElectricNetwork() {
		this(new HashSet<IConductor>());
	}

	public ElectricNetwork(Collection<? extends IConductor> varCables) {
		conductorSet.addAll(varCables);
		NetworkRegistry.register(this);
	}

	public ElectricNetwork(Set<AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack>> networks) {
		for (AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack> net : networks) {
			if (net != null) {
				conductorSet.addAll(net.conductorSet);
				net.deregister();
			}
		}
		refresh();
		NetworkRegistry.register(this);
	}

	public ElectricNetwork(Set<ElectricNetwork> networks, boolean special) {
		for (ElectricNetwork net : networks) {
			if (net != null) {
				conductorSet.addAll(net.conductorSet);
				net.deregister();
			}
		}
		refresh();
		NetworkRegistry.register(this);
	}

	@Override
	public void refresh() {
		resistance = 0;
		energyLoss = 0;
		voltage = 0.0;
		lastEnergyLoss = 0;
		lastVoltage = 0.0;
		currentProducers.clear();
		transferBuffer = 0;
		maxTransferBuffer = 0;

		minimumVoltage = -1;
		minimumAmpacity = 0;

		super.refresh();
	}

	private TransferPack sendToReceivers(TransferPack maxTransfer, ArrayList<BlockEntity> ignored, boolean debug) {
		if (maxTransfer.getJoules() <= 0 || maxTransfer.getVoltage() <= 0) {
			return TransferPack.EMPTY;
		}
		Set<BlockEntity> availableAcceptors = getEnergyAcceptors();
		double joulesSent = 0;
		availableAcceptors.removeAll(ignored);

		if (availableAcceptors.isEmpty()) {
			return TransferPack.EMPTY;
		}

		Iterator<BlockEntity> it = availableAcceptors.iterator();
		double totalUsage = 0;
		HashMap<BlockEntity, Double> usage = new HashMap<>();
		while (it.hasNext()) {
			BlockEntity receiver = it.next();
			double localUsage = 0;
			if (acceptorInputMap.containsKey(receiver)) {
				boolean shouldRemove = true;
				for (Direction connection : acceptorInputMap.get(receiver)) {
					TransferPack pack = ElectricityUtils.receivePower(receiver, connection, TransferPack.joulesVoltage(maxTransfer.getJoules(), maxTransfer.getVoltage()), true);
					if (pack.getJoules() != 0) {
						shouldRemove = false;
						totalUsage += pack.getJoules();
						localUsage += pack.getJoules();
						break;
					}
				}
				if (shouldRemove) {
					it.remove();
				}
			}
			usage.put(receiver, localUsage);
		}
		for (BlockEntity receiver : availableAcceptors) {
			TransferPack dedicated = TransferPack.joulesVoltage(maxTransfer.getJoules() * (usage.get(receiver) / totalUsage), maxTransfer.getVoltage());
			if (acceptorInputMap.containsKey(receiver)) {
				TransferPack perConnection = TransferPack.joulesVoltage(dedicated.getJoules() / acceptorInputMap.get(receiver).size(), maxTransfer.getVoltage());
				for (Direction connection : acceptorInputMap.get(receiver)) {
					TransferPack pack = ElectricityUtils.receivePower(receiver, connection, perConnection, debug);
					joulesSent += pack.getJoules();
					if (!debug) {
						transmittedThisTick += pack.getJoules();
					}
				}
			}
		}
		return TransferPack.joulesVoltage(Math.min(maxTransfer.getJoules(), joulesSent), maxTransfer.getVoltage());
	}

	public Set<BlockEntity> getEnergyAcceptors() {
		return new HashSet<>(acceptorSet);
	}

	private boolean checkForOverload() {

		if (voltage <= 0 || networkMaxTransfer * voltage - transmittedThisTick > 0) {
			return false;
		}

		HashSet<SubtypeWire> checkList = new HashSet<>();
		for (SubtypeWire type : SubtypeWire.values()) {
			if (type.conductor.ampacity <= transmittedLastTick / voltage * 20 && type.conductor.ampacity <= transmittedThisTick / voltage * 20) {
				checkList.add(type);
			}
		}
		for (SubtypeWire index : checkList) {
			for (IConductor conductor : conductorTypeMap.get(index)) {
				Scheduler.schedule(1, conductor::destroyViolently);
			}
		}
		return true;

	}

	@Override
	public void updateConductorStatistics(IConductor cable) {
		super.updateConductorStatistics(cable);
		resistance += cable.getWireType().resistance;

	}

	@Override
	public void updateRecieverStatistics(BlockEntity reciever, Direction dir) {
		reciever.getCapability(ElectrodynamicsCapabilities.ELECTRODYNAMIC, dir).ifPresent(cap -> {
			if (cap.getVoltage() < 0) {
				return;
			}

			if (minimumVoltage <= 0) {
				minimumVoltage = cap.getVoltage();
			} else if (cap.getVoltage() < minimumVoltage) {
				minimumVoltage = cap.getVoltage();
			}
		});
	}

	@Override
	public void updateStatistics() {
		resistance = 0;
		super.updateStatistics();
	}

	public void addProducer(BlockEntity tile, double d) {
		currentProducers.add(tile);
		voltage = Math.max(voltage, d);
	}

	@Override
	public void tick() {
		super.tick();
		if (transferBuffer > 0) {
			ArrayList<BlockEntity> producersList = new ArrayList<>(currentProducers);
			if ((int) voltage != 0 && voltage > 0) {
				if (resistance > 0) {
					double bufferAsWatts = transferBuffer * 20; // buffer as watts
					double maxWatts = (-voltage * voltage + voltage * Math.sqrt(voltage * voltage + 4 * bufferAsWatts * resistance)) / (2 * resistance);
					double maxPerTick = maxWatts / 20.0;
					// above is power as watts when powerSend + powerLossToWires = m
					TransferPack send = TransferPack.joulesVoltage(maxPerTick, voltage);
					double sent = sendToReceivers(send, producersList, false).getJoules();
					double lossPerTick = send.getAmps() * send.getAmps() * resistance / 20.0;
					transferBuffer -= sent + lossPerTick;
					energyLoss += lossPerTick;
					transmittedThisTick += lossPerTick;
					checkForOverload();
				} else {
					transferBuffer -= sendToReceivers(TransferPack.joulesVoltage(transferBuffer, voltage), producersList, false).getJoules();
				}
			}
		}
		lastVoltage = voltage;
		voltage = 0;
		lastEnergyLoss = energyLoss;
		energyLoss = 0;

		maxTransferBuffer = 0;
		currentProducers.clear();

		for (BlockEntity tile : acceptorSet) {
			if (acceptorInputMap.containsKey(tile)) {
				for (Direction connection : acceptorInputMap.get(tile)) {
					TransferPack pack = ElectricityUtils.receivePower(tile, connection, TransferPack.joulesVoltage(Double.MAX_VALUE, voltage), true);
					if (pack.getJoules() != 0) {
						maxTransferBuffer += pack.getJoules();
						break;
					}
				}
			}
		}
		Iterator<IConductor> it = conductorSet.iterator();
		boolean broken = false;
		while (it.hasNext()) {
			IConductor conductor = it.next();
			if (conductor instanceof BlockEntity entity && entity.isRemoved() || conductor.getNetwork() != this) {
				broken = true;
				break;
			}
		}
		if (broken) {
			refresh();
		}
		if (getSize() == 0) {
			deregister();
		}

	}

	@Override
	public boolean isConductor(BlockEntity tile, IConductor requesterCable) {
		return ElectricityUtils.isConductor(tile, requesterCable);
	}

	@Override
	public boolean isConductorClass(BlockEntity tile) {
		return tile instanceof IConductor;
	}

	@Override
	public boolean isAcceptor(BlockEntity acceptor, Direction orientation) {
		return ElectricityUtils.isElectricReceiver(acceptor);
	}

	@Override
	public AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack> createInstance() {
		return new ElectricNetwork();
	}

	@Override
	public AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack> createInstanceConductor(Set<IConductor> conductors) {
		return new ElectricNetwork(conductors);
	}

	@Override
	public AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack> createInstance(Set<AbstractNetwork<IConductor, SubtypeWire, BlockEntity, TransferPack>> networks) {
		return new ElectricNetwork(networks);

	}

	@Override
	public SubtypeWire[] getConductorTypes() {
		return SubtypeWire.values();
	}

	@Override
	public boolean canConnect(BlockEntity acceptor, Direction orientation) {
		return ElectricityUtils.canInputPower(acceptor, orientation.getOpposite());
	}

	@Override
	public double getJoulesStored() {
		return transferBuffer;
	}

	@Override
	public void setJoulesStored(double joules) {
		transferBuffer = joules;
	}

	@Override
	public double getMaxJoulesStored() {
		return maxTransferBuffer;
	}

	@Override
	public void onChange() {

	}

	@Override
	public double getMinimumVoltage() {
		return minimumVoltage;
	}

	public long getMinimumAmpacity() {
		return minimumAmpacity;
	}
	
}