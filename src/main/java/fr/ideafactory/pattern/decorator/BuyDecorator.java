package fr.ideafactory.pattern.decorator;

public abstract class BuyDecorator implements Buy {
	private Buy buyEquipment;
	
	public BuyDecorator(Buy buyEquipment) {
		this.buyEquipment = buyEquipment;
	}
	
	@Override
	public Double cost() {
		// TODO Auto-generated method stub
		return this.buyEquipment.cost();
	}

}
