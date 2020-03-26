package physica.core.common.item.subtypes;

public enum EnumIngot {
	copper("ingotCopper"), tin("ingotTin"), silver("ingotSilver"), steel("ingotSteel"), lead("ingotLead"),
	superconductive("ingotSuperConductive"), bronze("ingotBronze");

	private String ore;

	private EnumIngot(String ore) {
		this.ore = ore;
	}

	public String getOre() {
		return ore;
	}
}