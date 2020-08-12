package katamodel;

import java.util.List;

// score table 
public class ScoreTable {
	private List<SetScore> setScore;
	private List<Game> gameScore;
	private int winner;

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public List<SetScore> getSetScore() {
		return setScore;
	}

	public void setSetScore(List<SetScore> set) {
		this.setScore = set;
	}

	public List<Game> getGameScore() {
		return gameScore;
	}

	public void setGameScore(List<Game> games) {
		this.gameScore = games;
	}

}
