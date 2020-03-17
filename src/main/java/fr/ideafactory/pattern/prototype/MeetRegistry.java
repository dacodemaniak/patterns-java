package fr.ideafactory.pattern.prototype;

import java.util.HashMap;
import java.util.Optional;

public class MeetRegistry {
	private HashMap<Integer, Meet> meets = new HashMap<Integer, Meet>();
	
	public void add(Meet meet) {
		this.meets.put(this.meets.size() + 1, meet);
	}
	
	public HashMap<Integer, Meet> get() {
		return this.meets;
	}
	
	public Meet byId(Integer id) {
		return this.meets.get(id);
	}
}
