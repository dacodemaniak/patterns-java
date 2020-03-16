package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.exceptions.ProtectionNotFoundException;
import fr.ideafactory.pattern.exceptions.WeaponNotFoundException;

public interface AbstractFactory<T> {
	T create(String whatToCreate) throws WeaponNotFoundException, ProtectionNotFoundException;
}
