package fr.ideafactory.pattern.prototype;

public class Fight extends Meet {

	private Integer winnerGains;
	
	public Fight() {
		super();
	}
	
	public Fight(Fight meet) {
		super(meet);
		this.winnerGains = meet.winnerGains;
	}
	
	public MeetPrototype clone() {
		// TODO Auto-generated method stub
		return new Fight(this);
	}
	
	public void setWinnerGains(Integer points) {
		this.winnerGains = points;
	}
	
	public Integer getWinnerGains() {
		return this.winnerGains;
	}

}
