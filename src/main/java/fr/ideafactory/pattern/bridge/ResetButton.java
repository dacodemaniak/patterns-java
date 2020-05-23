package fr.ideafactory.pattern.bridge;

public class ResetButton implements TypeImplementation {

	@Override
	public String implRender() {
		return "reset";
	}

}
