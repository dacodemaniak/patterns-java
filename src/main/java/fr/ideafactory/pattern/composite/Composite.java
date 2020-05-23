package fr.ideafactory.pattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements TotalizableComponent {
	private List<TotalizableComponent> nodes;
	private Double total = 0.0;
	
	public Composite() {
		this.nodes = new ArrayList<TotalizableComponent>();
	}
	@Override
	public Double totalize() {
		// TODO Auto-generated method stub
		this.nodes.forEach((TotalizableComponent node) -> {
				this.total += node.totalize();
		});
		return this.total;
	}
	
	public Composite add(TotalizableComponent component) {
		this.nodes.add(component);
		return this;
	}
	
	public Composite remove(TotalizableComponent component) {
		if (this.nodes.contains(component)) {
			this.nodes.remove(component);
		}
		return this;
	}
	
	public List<TotalizableComponent> getNodes() {
		return this.nodes;
	}

	public Boolean hasChildren() {
		return !this.nodes.isEmpty();
	}

}
