package fr.ideafactory.pattern.builder;

import fr.ideafactory.pattern.models.Armour;
import fr.ideafactory.pattern.models.Gun;
import fr.ideafactory.pattern.models.Hero;

public class StrongHeroBuilder implements HeroBuilder {

	protected Hero hero;
	
	public void reset() {
		this.hero = null;
	}

	public void buildCharacter() {
		this.hero = new Hero();
	}

	public void buildWeapon() {
		this.hero.setWeapon(new Gun());
	}

	public void buildProtection() {
		this.hero.setProtection(new Armour());
	}
	
	public Hero get() {
		return this.hero;
	}

}
