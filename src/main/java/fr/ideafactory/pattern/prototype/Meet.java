package fr.ideafactory.pattern.prototype;

import fr.ideafactory.pattern.models.Bad;
import fr.ideafactory.pattern.models.Hero;

abstract public class Meet implements MeetPrototype {
	protected Hero hero;
	protected Bad bad;
	
	public Meet() {}
	
	public Meet(MeetPrototype prototype) {
		this.hero = prototype.getHero();
		this.bad = prototype.getBad();
	}
	
	abstract public MeetPrototype clone();

	public Hero getHero() {
		return this.hero;
	}
	
	public void setHero(Hero hero) {
		this.hero = hero;
	}

	public Bad getBad() {
		return this.bad;
	}
	
	public void setBad(Bad bad) {
		this.bad = bad;
	}
	
	public String toString() {
		String message = this.hero.whoAreYou() + " meets " + this.bad.whoAreYou() + "\n";
		
		if (this instanceof Fight) {
			message += " for a fight";
		} else {
			message += " for a negociation";
		}
		
		message += "\nPoints involved : ";
		
		if (this instanceof Fight) {
			message += ((Fight) this).getWinnerGains();
		} else {
			message += ((Negociation)this).getPointExchanges();
		}
		return message;
	}

}
