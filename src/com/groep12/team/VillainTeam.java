package com.groep12.team;

import com.groep12.Person.Villain;

import java.util.ArrayList;


public class VillainTeam extends Team {


	private ArrayList<Villain> members = new ArrayList<>();


	public VillainTeam(String name) {
		super(name);
	}

	@Override
	public void showDetails() {
		StringBuilder detailStr = new StringBuilder();
		String headerStr = "|Team of villains " + super.getName() + " details|\n";

		//.repeat() was a java 11 function. Back to ye olde loop it is
		for(int i = 0; i < headerStr.length() + 2;  i++){
			detailStr.append("~");
		}

		detailStr.append(headerStr);


		for(int i = 0; i < headerStr.length() + 2;  i++){
			detailStr.append("~");
		}
		String nameLine = "Dark alliance name: " + super.getName() + "\n";
		detailStr.append(nameLine);
		String powerLevelLine = "Power-level: " + getTeamPowerLevel() + "\n";
		detailStr.append(powerLevelLine);
		String amntOfMembers = "The dark alliance has " + members.size() + " misfits";
		detailStr.append(amntOfMembers);


		System.out.println(detailStr);
	}

	public void addToVillainTeam(Villain villain){
		this.members.add(villain);
	}

	public int getTeamPowerLevel() {
		int powerLevel = 0;
		for(Villain villain : members){
			powerLevel+= villain.getAdjustedPowerLevel();
		}
		return powerLevel;
	}
	public ArrayList<Villain> getMembers(){
		return this.members;
	}
}
