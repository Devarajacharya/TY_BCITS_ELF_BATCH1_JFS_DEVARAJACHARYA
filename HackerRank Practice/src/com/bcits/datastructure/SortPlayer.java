package com.bcits.datastructure;

import java.util.Comparator;

public class SortPlayer implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		if (o1.getScore() == o2.getScore()) {
			return o1.getName().compareTo(o2.getName());
		}
		return o2.getScore() - o1.getScore();
	}

}
