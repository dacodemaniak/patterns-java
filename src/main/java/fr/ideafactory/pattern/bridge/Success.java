package fr.ideafactory.pattern.bridge;

public class Success implements ColorImplementation {
	final private String cssClass = "btn btn-success";
	@Override
	public String getBootstrapClass() {
		return this.cssClass;
	}

}
