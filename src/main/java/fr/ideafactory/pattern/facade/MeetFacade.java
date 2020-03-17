package fr.ideafactory.pattern.facade;

import java.util.Random;

import fr.ideafactory.pattern.prototype.Fight;
import fr.ideafactory.pattern.prototype.Meet;
import fr.ideafactory.pattern.prototype.Negociation;
import fr.ideafactory.pattern.models.Bad;
import fr.ideafactory.pattern.models.Character;
import fr.ideafactory.pattern.models.Hero;

public class MeetFacade {
	private Meet meet;
	
	public MeetFacade(Meet meet) {
		this.meet = meet;
		
		this.meet();
	}
	
	/**
	 * Business logic for a Meet
	 * 	- If Negociation, simple points exchange
	 *  - If Fight : determine winner, from winner settings, set points,
	 *  	update model
	 */
	private void meet() {
		if (this.meet instanceof Negociation) {
			
		} else {
			// Get randomize winner
			Random randomize = new Random();
			int low = 0;
			int high = 1;
			int index = randomize.nextInt(high - low) + low;
			
			// Updates points according meeting settings
			if (index == 0) {
				((Hero) this.meet.getHero()).setLifePoints(this.meet.getHero().getLifePoints() + ((Fight) this.meet).getWinnerGains());
				((Bad) this.meet.getBad()).setLifePoints(this.meet.getBad().getLifePoints() - ((Fight) this.meet).getWinnerGains());
			} else {
				((Bad) this.meet.getBad()).setLifePoints(this.meet.getBad().getLifePoints() + ((Fight) this.meet).getWinnerGains());
				((Hero) this.meet.getHero()).setLifePoints(this.meet.getHero().getLifePoints() - ((Fight) this.meet).getWinnerGains());
			}
			
			// Some other logic...
		}
	}
}
