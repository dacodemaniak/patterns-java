package fr.ideafactory.pattern.composite;

public class Component implements TotalizableComponent {
	public String name;
	private Double total;
	
	public Component(String name, Double total) {
		this.name = name;
		this.total = total;
	}
	
	@Override
	public Double totalize() {
		// TODO Auto-generated method stub
		return this.total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public String toString() {
		return "I'm a " + this.name + " value : " + this.total;
	}
	
	public Boolean hasChildren() {
		return false;
	}

}
