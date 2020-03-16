package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.exceptions.WeaponNotFoundException;
import fr.ideafactory.pattern.models.Gun;
import fr.ideafactory.pattern.models.Knife;
import fr.ideafactory.pattern.models.Weapon;

public class WeaponFactory implements AbstractFactory<Weapon> {

	public Weapon create(String whatToCreate) throws WeaponNotFoundException {
		if ("Gun".equalsIgnoreCase(whatToCreate)) {
			return new Gun();
		} else if ("Knife".equalsIgnoreCase(whatToCreate)) {
			return new Knife();
		}
		
		throw new WeaponNotFoundException("No weapon were found for type : " + whatToCreate);
	}

}
