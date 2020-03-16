package fr.ideafactory.pattern.factory;

import fr.ideafactory.pattern.exceptions.ProtectionNotFoundException;
import fr.ideafactory.pattern.exceptions.WeaponNotFoundException;
import fr.ideafactory.pattern.models.Armour;
import fr.ideafactory.pattern.models.Gun;
import fr.ideafactory.pattern.models.Knife;
import fr.ideafactory.pattern.models.Protection;
import fr.ideafactory.pattern.models.Umbrella;

public class ProtectionFactory implements AbstractFactory<Protection> {

	public Protection create(String whatToCreate) throws ProtectionNotFoundException {
		if ("Armour".equalsIgnoreCase(whatToCreate)) {
			return new Armour();
		} else if ("Umbrella".equalsIgnoreCase(whatToCreate)) {
			return new Umbrella();
		}
		
		throw new ProtectionNotFoundException("No protection were found for type : " + whatToCreate);
	}

}
