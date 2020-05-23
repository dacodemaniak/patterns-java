package fr.ideafactory.pattern.decorator;

public class BuyEquipmentWithExtra extends BuyDecorator {
	public BuyEquipmentWithExtra(Buy buyEquipment) {
		super(buyEquipment);
	}
	
	public Double cost() {
		Double cost = super.cost();
		cost += this.extra();
		
		return cost;
	}
	
	private Double extra() {
		return 75.00;
	}
}
