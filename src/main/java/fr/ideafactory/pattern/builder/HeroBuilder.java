package fr.ideafactory.pattern.builder;

import fr.ideafactory.pattern.models.Hero;

public interface HeroBuilder {
	public void reset();
	
	public void buildCharacter();
	
	public void buildWeapon();
	
	public void buildProtection();
	
	public Hero get();
}
