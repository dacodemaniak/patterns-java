package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.models.Character;

abstract public class CharacterFactory {
	public Character getCharacter() {
		return createCharacter();
	}
	
	abstract public Character createCharacter();
}
