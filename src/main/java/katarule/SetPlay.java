package katarule;

import java.util.ArrayList;
import java.util.List;

import kataenum.GameEnum;
import katamodel.Game;
import katamodel.GameScore;
import katamodel.Player;
import katamodel.ScoreTable;
import katamodel.SetScore;
import katamodel.TieScore;

public class SetPlay {
	private int mode;
	private Player p1;
	private Player p2;
	private ScoreTable set;

	public ScoreTable getSet() {
		return set;
	}

	public void initGame() {
		set = new ScoreTable();
		List<SetScore> scorelist = new ArrayList<SetScore>();
		scorelist.add(new SetScore(0, 0));
		set.setSetScore(scorelist);
		List<GameScore> gameScores = new ArrayList<GameScore>();
		gameScores.add(new GameScore(GameEnum.LOVE, GameEnum.LOVE));
		List<TieScore> ties = new ArrayList<TieScore>();
		ties.add(new TieScore(0, 0));
		Game ng = new Game();
		ng.setGames(gameScores);
		ng.setTies(ties);
		List<Game> gamelist = new ArrayList<Game>();
		gamelist.add(ng);

		set.setGameScore(gamelist);
		set.setWinner(0);
	}

	public void play() throws Exception {
		while (set.getWinner() == 0) {
			Thread.sleep(20);

			SetScore setScoreNow = set.getSetScore().get(set.getSetScore().size() - 1);
			Game gameScoreNow = set.getGameScore().get(set.getGameScore().size() - 1);
			// simulate play
			GamePlay game = new GamePlay();
			int winner = (Math.random() <= 0.5) ? 1 : 2;

			// note new score
			SetScore newSetScore = game.note(setScoreNow, gameScoreNow, winner);
			if (!(newSetScore.getP1() == setScoreNow.getP1() && newSetScore.getP2() == setScoreNow.getP2())) {
				set.getSetScore().add(newSetScore);
				System.out.println("Player : " + winner + " got 1 point! ");
				System.out.println("new Score : " + newSetScore.getP1() + " vs " + newSetScore.getP2());
			}

			// end of set
			if ((newSetScore.getP1() == 7 || newSetScore.getP2() == 7)
					|| ((newSetScore.getP1() == 6 || newSetScore.getP2() == 6)
							&& Math.abs(newSetScore.getP1() - newSetScore.getP2()) > 1)) {
				set.setWinner(winner);
			}

		}
		afficheScoreTable();
	}

	private void afficheScoreTable() {
		System.out.println("The winner of Set is : " + set.getWinner());
		for (SetScore element : set.getSetScore()) {
			// print each element of the array
			System.out.println(element.getP1() + " : " + element.getP2());
		}

	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
}
