package fr.ideafactory.pattern.bridge;

public class Danger implements ColorImplementation {
	private final String cssClass = "btn btn-danger";
	
	@Override
	public String getBootstrapClass() {
		return this.cssClass;
	}

}
