package fr.ideafactory.pattern.models;

public class Hero extends Character {
	public String whoAreYou() {
		String greetings = "I'm " + name + " and i'm a hero";
		
		if (this.weapon != null) {
			greetings += " And have a " + this.weapon.getType();
		}
		
		if (this.protection != null) {
			greetings += " I'm protected for " + this.protection.getDuration() + " minutes";
		}
		return greetings;
	}
}
