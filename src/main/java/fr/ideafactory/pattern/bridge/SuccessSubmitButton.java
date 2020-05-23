package fr.ideafactory.pattern.bridge;

public class SuccessSubmitButton extends Button {
	public SuccessSubmitButton() {
		this.type = new SubmitButton();
		this.color = new Success();
	}
}
