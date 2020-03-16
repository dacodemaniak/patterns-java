package fr.ideafactory.pattern.factory;

public class FactoryProvider {
	public static AbstractFactory getFactory(String whatFactory) {
		if ("Weapon".equalsIgnoreCase(whatFactory)) {
			return new WeaponFactory();
		} else if ("Protection".equalsIgnoreCase(whatFactory)) {
			return new ProtectionFactory();
		}
		return new WeaponFactory();
	}
}
