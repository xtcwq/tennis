package katamodel;

import java.util.List;

public class SetGame {
	private List<GameScore> games;
	private Player winner;

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public List<GameScore> getGames() {
		return games;
	}

	public void setGames(List<GameScore> games) {
		this.games = games;
	}

}
