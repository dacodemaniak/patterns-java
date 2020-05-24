package fr.ideafactory.pattern.bridge;

public class ActionButton implements TypeImplementation {

	@Override
	public String implRender() {
		return "button";
	}

}
