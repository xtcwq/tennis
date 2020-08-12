package katamodel;

import java.util.List;

public class Game {
	private List<GameScore> scores;
	private List<TieScore> ties;

	public List<GameScore> getGames() {
		return scores;
	}

	public void setGames(List<GameScore> games) {
		this.scores = games;
	}

	public List<TieScore> getTies() {
		return ties;
	}

	public void setTies(List<TieScore> ties) {
		this.ties = ties;
	}
}
