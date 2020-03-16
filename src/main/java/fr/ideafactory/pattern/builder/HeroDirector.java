package fr.ideafactory.pattern.builder;

public class HeroDirector {
	private HeroBuilder builder;
	
	public void setBuilder(HeroBuilder builder) {
		this.builder = builder;
	}
	
	public void make() {
		this.builder.buildCharacter();
		this.builder.buildWeapon();
		
		if (this.builder instanceof StrongHeroBuilder) {
			this.builder.buildProtection();
		}
	}
}
