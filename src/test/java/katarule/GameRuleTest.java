package katarule;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import kataenum.GameEnum;
import katamodel.GameScore;
import katamodel.TieScore;

public class GameRuleTest extends TestCase {

	// US1
	@Test
	public void testSimpleRule() {
		// 0 0 => 0 15 or 15 0
		GameScore score1 = new GameScore(GameEnum.LOVE, GameEnum.LOVE);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FIFTEEN);
		assertEquals(score1.getP2(), GameEnum.LOVE);

		GameScore score2 = new GameScore(GameEnum.LOVE, GameEnum.LOVE);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.FIFTEEN);

		// 0 15 => 15 15 or 0 30
		score1.setP1(GameEnum.LOVE);
		score1.setP2(GameEnum.FIFTEEN);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FIFTEEN);
		assertEquals(score1.getP2(), GameEnum.FIFTEEN);

		score2.setP1(GameEnum.LOVE);
		score2.setP2(GameEnum.FIFTEEN);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.THIRTY);

		// 0 30 => 0 40 or 15 30
		score1.setP1(GameEnum.LOVE);
		score1.setP2(GameEnum.THIRTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FIFTEEN);
		assertEquals(score1.getP2(), GameEnum.THIRTY);

		score2.setP1(GameEnum.LOVE);
		score2.setP2(GameEnum.THIRTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.FORTY);

		// 0 40 => 15 40 or end
		score1.setP1(GameEnum.LOVE);
		score1.setP2(GameEnum.FORTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FIFTEEN);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		score2.setP1(GameEnum.LOVE);
		score2.setP2(GameEnum.FORTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.LOVE);

		// 15 15 => 15 30 or 30 15
		score1.setP1(GameEnum.FIFTEEN);
		score1.setP2(GameEnum.FIFTEEN);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.THIRTY);
		assertEquals(score1.getP2(), GameEnum.FIFTEEN);

		score2.setP1(GameEnum.FIFTEEN);
		score2.setP2(GameEnum.FIFTEEN);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.FIFTEEN);
		assertEquals(score2.getP2(), GameEnum.THIRTY);

		// 15 30 => 15 40 or 30 30
		score1.setP1(GameEnum.FIFTEEN);
		score1.setP2(GameEnum.THIRTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.THIRTY);
		assertEquals(score1.getP2(), GameEnum.THIRTY);

		score2.setP1(GameEnum.FIFTEEN);
		score2.setP2(GameEnum.THIRTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.FIFTEEN);
		assertEquals(score2.getP2(), GameEnum.FORTY);

		// 15 40 => 30 40 or end
		score1.setP1(GameEnum.FIFTEEN);
		score1.setP2(GameEnum.FORTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.THIRTY);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		score2.setP1(GameEnum.FIFTEEN);
		score2.setP2(GameEnum.FORTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.LOVE);

		// 30 30 => 30 40 or 40 30
		score1.setP1(GameEnum.THIRTY);
		score1.setP2(GameEnum.THIRTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FORTY);
		assertEquals(score1.getP2(), GameEnum.THIRTY);

		score2.setP1(GameEnum.THIRTY);
		score2.setP2(GameEnum.THIRTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.THIRTY);
		assertEquals(score2.getP2(), GameEnum.FORTY);

		// 30 40 =>40 40 or end
		score1.setP1(GameEnum.THIRTY);
		score1.setP2(GameEnum.FORTY);
		score1 = GameRule.simpleRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FORTY);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		score2.setP1(GameEnum.THIRTY);
		score2.setP2(GameEnum.FORTY);
		score2 = GameRule.simpleRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.LOVE);

	}

	// US2
	@Test
	public void testDeuseRule() {
		// 40 40 => 40 ADV
		GameScore score1 = new GameScore(GameEnum.FORTY, GameEnum.FORTY);
		score1 = GameRule.deuseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.ADV);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		GameScore score2 = new GameScore(GameEnum.FORTY, GameEnum.FORTY);
		score2 = GameRule.deuseRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.FORTY);
		assertEquals(score2.getP2(), GameEnum.ADV);

		// 40 ADV => DEUCE or end
		score1.setP1(GameEnum.FORTY);
		score1.setP2(GameEnum.ADV);
		score1 = GameRule.deuseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.DEUCE);
		assertEquals(score1.getP2(), GameEnum.DEUCE);

		score2.setP1(GameEnum.FORTY);
		score2.setP2(GameEnum.ADV);
		score2 = GameRule.deuseRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.LOVE);
		assertEquals(score2.getP2(), GameEnum.LOVE);

		// DEUCE => 40 ADV
		score1.setP1(GameEnum.DEUCE);
		score1.setP2(GameEnum.DEUCE);
		score1 = GameRule.deuseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.ADV);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		score2.setP1(GameEnum.DEUCE);
		score2.setP2(GameEnum.DEUCE);
		score2 = GameRule.deuseRule(score2, 2);
		assertEquals(score2.getP1(), GameEnum.FORTY);
		assertEquals(score2.getP2(), GameEnum.ADV);

	}

	@Test
	public void testChooseRule() {

		// 0 15 => simple
		GameScore score1 = new GameScore(GameEnum.LOVE, GameEnum.LOVE);
		score1 = GameRule.chooseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.FIFTEEN);
		assertEquals(score1.getP2(), GameEnum.LOVE);

		// 30 40 => simple
		score1.setP1(GameEnum.THIRTY);
		score1.setP2(GameEnum.FORTY);
		score1 = GameRule.chooseRule(score1, 2);
		assertEquals(score1.getP1(), GameEnum.LOVE);
		assertEquals(score1.getP2(), GameEnum.LOVE);

		// 40 40 => deuse
		score1.setP1(GameEnum.FORTY);
		score1.setP2(GameEnum.FORTY);
		score1 = GameRule.chooseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.ADV);
		assertEquals(score1.getP2(), GameEnum.FORTY);

		// 40 ad => deuse
		score1.setP1(GameEnum.FORTY);
		score1.setP2(GameEnum.ADV);
		score1 = GameRule.chooseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.DEUCE);
		assertEquals(score1.getP2(), GameEnum.DEUCE);
		// deuse
		score1.setP1(GameEnum.DEUCE);
		score1.setP2(GameEnum.DEUCE);
		score1 = GameRule.chooseRule(score1, 1);
		assertEquals(score1.getP1(), GameEnum.ADV);
		assertEquals(score1.getP2(), GameEnum.FORTY);
	}

	@Test
	public void testTie() {
		// 0-6 same as simpleRule
		TieScore score1 = new TieScore(0, 0);
		score1 = GameRule.tieRule(score1, 1);
		assertEquals(1, score1.getP1());
		assertEquals(0, score1.getP2());

		// till 6 vs 5
		score1.setP1(6);
		score1.setP2(5);
		score1 = GameRule.tieRule(score1, 1);
		assertEquals(0, score1.getP1());
		assertEquals(0, score1.getP2());

		score1.setP1(6);
		score1.setP2(5);
		score1 = GameRule.tieRule(score1, 2);
		assertEquals(6, score1.getP1());
		assertEquals(6, score1.getP2());

		score1.setP1(6);
		score1.setP2(6);
		score1 = GameRule.tieRule(score1, 1);
		assertEquals(7, score1.getP1());
		assertEquals(6, score1.getP2());

		score1.setP1(7);
		score1.setP2(6);
		score1 = GameRule.tieRule(score1, 1);
		assertEquals(0, score1.getP1());
		assertEquals(0, score1.getP2());

		score1.setP1(7);
		score1.setP2(7);
		score1 = GameRule.tieRule(score1, 1);
		assertEquals(8, score1.getP1());
		assertEquals(7, score1.getP2());

	}

}
