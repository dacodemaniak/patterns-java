package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.models.Character;
import fr.ideafactory.pattern.models.Hero;

public class HeroFactory extends CharacterFactory {

	@Override
	public Character createCharacter() {
		return new Hero();
	}

}
