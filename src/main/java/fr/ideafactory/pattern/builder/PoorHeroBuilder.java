package fr.ideafactory.pattern.builder;

import fr.ideafactory.pattern.models.Hero;
import fr.ideafactory.pattern.models.Knife;

public class PoorHeroBuilder implements HeroBuilder {
	protected Hero hero;
	
	public void reset() {
		this.hero = null;
	}

	public void buildCharacter() {
		this.hero = new Hero();
	}

	public void buildWeapon() {
		this.hero.setWeapon(new Knife());
	}

	public void buildProtection() {
		return;
	}
	
	public Hero get() {
		return this.hero;
	}

}
