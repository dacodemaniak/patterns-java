package fr.ideafactory.pattern.models;

public abstract class Character {
	protected Weapon weapon;
	protected Protection protection;
	protected Integer lifePoints;
	
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void setProtection(Protection protection) {
		this.protection = protection;
	}
	
	public void setLifePoints(Integer lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	public Integer getLifePoints() {
		return this.lifePoints;
	}
	
	public abstract String whoAreYou();
}
