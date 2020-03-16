package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.models.Character;
import fr.ideafactory.pattern.models.Bad;

public class BadFactory extends CharacterFactory {

	@Override
	public Character createCharacter() {
		return new Bad();
	}

}
