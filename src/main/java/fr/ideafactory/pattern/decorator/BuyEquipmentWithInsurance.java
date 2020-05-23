package fr.ideafactory.pattern.decorator;

public class BuyEquipmentWithInsurance extends BuyDecorator {

	public BuyEquipmentWithInsurance(Buy buyEquipment) {
		super(buyEquipment);
	}
	
	public Double cost() {
		Double cost = super.cost();
		cost += this.insurance();
		
		return cost;
	}
	
	private Double insurance() {
		return 50.00;
	}

}
