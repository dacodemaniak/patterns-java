package fr.ideafactory.pattern.prototype;

public class Negociation extends Meet {

	private Integer pointExchanges;
	
	public Negociation() {
		super();
	}
	
	public Negociation(Negociation meet) {
		super(meet);
		this.pointExchanges = meet.pointExchanges;
	}
	
	public MeetPrototype clone() {
		// TODO Auto-generated method stub
		return new Negociation(this);
	}
	
	public void setPointExchanges(Integer points) {
		this.pointExchanges = points;
	}
	
	public Integer getPointExchanges() {
		return this.pointExchanges;
	}

}
