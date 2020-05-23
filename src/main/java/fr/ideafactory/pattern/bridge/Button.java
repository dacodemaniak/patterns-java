package fr.ideafactory.pattern.bridge;

public abstract class Button {
	protected TypeImplementation type;
	protected ColorImplementation color;
	
	public String render() {
		return "<button type=\"" + this.type.implRender() + "\" class=\"" + this.color.getBootstrapClass() + "\">Button</button>";
	}
}
