package katarule;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kataenum.GameEnum;
import katamodel.Game;
import katamodel.GameScore;
import katamodel.SetScore;
import katamodel.TieScore;

public class GamePlayTest {

	@Test
	public void testNote() throws Exception {
		// no change
		GamePlay gp = new GamePlay();
		Game game = new Game();
		List<GameScore> lgs = new ArrayList<GameScore>();
		lgs.add(new GameScore(GameEnum.LOVE, GameEnum.LOVE));
		game.setGames(lgs);
		List<TieScore> ties = new ArrayList<TieScore>();
		ties.add(new TieScore(0, 0));
		game.setTies(ties);

		SetScore oldScore = new SetScore(0, 0);

		SetScore newSs = gp.note(oldScore, game, 1);
		assertEquals(0, newSs.getP1());
		assertEquals(0, newSs.getP2());

		newSs = gp.note(oldScore, game, 1);
		assertEquals(0, newSs.getP1());
		assertEquals(0, newSs.getP2());

		newSs = gp.note(oldScore, game, 1);
		assertEquals(0, newSs.getP1());
		assertEquals(0, newSs.getP2());

		// got 1 point
		oldScore.setP1(2);
		newSs = gp.note(oldScore, game, 1);
		assertEquals(3, newSs.getP1());
		assertEquals(0, newSs.getP2());

		// end of 6
		oldScore.setP1(5);
		newSs = gp.note(oldScore, game, 1);
		assertEquals(5, newSs.getP1());
		assertEquals(0, newSs.getP2());

		oldScore.setP1(5);
		newSs = gp.note(oldScore, game, 1);
		assertEquals(5, newSs.getP1());
		assertEquals(0, newSs.getP2());

		oldScore.setP1(5);
		newSs = gp.note(oldScore, game, 1);
		assertEquals(5, newSs.getP1());
		assertEquals(0, newSs.getP2());

		oldScore.setP1(5);
		newSs = gp.note(oldScore, game, 1);
		assertEquals(6, newSs.getP1());
		assertEquals(0, newSs.getP2());

		// tie break
		oldScore.setP1(6);
		oldScore.setP2(6);

		game.getTies().add(new TieScore(0, 0));
		newSs = gp.note(oldScore, game, 1);
		assertEquals(6, newSs.getP1());
		assertEquals(6, newSs.getP2());

		oldScore.setP1(6);
		oldScore.setP2(6);
		game.getTies().add(new TieScore(6, 0));
		newSs = gp.note(oldScore, game, 1);
		assertEquals(7, newSs.getP1());
		assertEquals(6, newSs.getP2());

		// tie break more than 2
		oldScore.setP1(6);
		oldScore.setP2(6);
		game.getTies().add(new TieScore(6, 6));
		newSs = gp.note(oldScore, game, 1);
		assertEquals(6, newSs.getP1());
		assertEquals(6, newSs.getP2());

		oldScore.setP1(6);
		oldScore.setP2(6);
		game.getTies().add(new TieScore(6, 7));
		newSs = gp.note(oldScore, game, 1);
		assertEquals(6, newSs.getP1());
		assertEquals(6, newSs.getP2());

		oldScore.setP1(6);
		oldScore.setP2(6);
		game.getTies().add(new TieScore(8, 7));
		newSs = gp.note(oldScore, game, 1);
		assertEquals(7, newSs.getP1());
		assertEquals(6, newSs.getP2());
	}

}
