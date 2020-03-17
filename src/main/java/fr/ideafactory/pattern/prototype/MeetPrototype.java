package fr.ideafactory.pattern.prototype;

import fr.ideafactory.pattern.models.Bad;
import fr.ideafactory.pattern.models.Hero;

public interface MeetPrototype {
	public MeetPrototype clone();
	public void setHero(Hero hero);
	public void setBad(Bad bad);
	public Hero getHero();
	public Bad getBad();
}
