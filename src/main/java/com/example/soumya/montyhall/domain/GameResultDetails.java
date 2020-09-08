package com.example.soumya.montyhall.domain;

import java.util.List;

public class GameResultDetails {
	
    private int iteration;
	private List<String> doors;
	private int selectedDoor;
    private boolean win;
    private boolean switchFlag;
    
    public GameResultDetails() {
    }

    public GameResultDetails(int iterationNo, List<String> doorList, int  selected, boolean winFlag, boolean switchFlag) {
    	this.iteration = iterationNo;
        this.doors = doorList;
        this.selectedDoor = selected;
        this.win = winFlag;
        this.switchFlag = switchFlag;
    }

    public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

    public List<String> getDoors() {
		return doors;
	}

	public void setDoors(List<String> doors) {
		this.doors = doors;
	}

	public int getSelectedDoor() {
		return selectedDoor;
	}

	public void setSelectedDoor(int selectedDoor) {
		this.selectedDoor = selectedDoor;
	}

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public boolean isSwitchFlag() {
		return switchFlag;
	}

	public void setSwitchFlag(boolean switchFlag) {
		this.switchFlag = switchFlag;
	}

}
