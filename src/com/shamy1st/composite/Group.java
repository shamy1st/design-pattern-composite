package com.shamy1st.composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component {
	
	private List<Component> components = new ArrayList<>();
	
	public void add(Component component) {
		components.add(component);
	}
	
	@Override
	public void render() {
		components.forEach(component -> component.render());
	}

	@Override
	public void move() {
		components.forEach(component -> component.move());
	}
}
