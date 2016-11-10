package com.mygdx.game;

public class Score {
	private int score;
	
	public Score(int number) {
		score = number;
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseOnePoint() {
		score++;
	}
	
	public void increaseTwoPoint() {
		score += 2;
	}
	
	public void increaseThreePoint() {
		score += 3;
	}
	
}
