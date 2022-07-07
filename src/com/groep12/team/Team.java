package com.groep12.team;
import com.groep12.interfaces.Details;


public abstract class Team implements Details {

	private final String name;

	public Team(String name) {
		this.name = name;
	}

	//GETTERS
	public String getName() {
		return name;
	}


}
