package com.bcits.datastructure;

public class Player {

	private String name;
	private int score;

	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "name = " + name + "   , score=" + score;
	}

}
