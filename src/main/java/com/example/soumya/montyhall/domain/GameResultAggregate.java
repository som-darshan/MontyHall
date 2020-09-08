package com.example.soumya.montyhall.domain;


public class GameResultAggregate {

    private int numberOfIterations;
    private int numberOfWins;
	private float percentage;
	private boolean switchFlag;

    public GameResultAggregate() {
    }

    public GameResultAggregate(int numberOfIterations, boolean  switchFlag) {
        this.numberOfIterations = numberOfIterations;
        this.switchFlag = switchFlag;
        this.numberOfWins = 0;
        this.percentage = 0.0f;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public boolean isSwitchFlag() {
		return switchFlag;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

    public float getPercentage() {
        return this.percentage;
    }

}
