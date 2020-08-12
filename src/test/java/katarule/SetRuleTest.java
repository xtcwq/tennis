package katarule;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import katamodel.SetScore;

public class SetRuleTest extends TestCase {

	@Test
	public void testSimple() {
		// 0 0 => 0 1 or 1 0
		SetScore score1 = new SetScore(0, 0);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(1, score1.getP1());
		assertEquals(0, score1.getP2());

		SetScore score2 = new SetScore(0, 0);
		score2 = SetRule.simpleRule(score2, 2);
		assertEquals(0, score2.getP1());
		assertEquals(1, score2.getP2());

		// 0 1 => 0 2 or 1 1
		score1.setP1(0);
		score1.setP2(1);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(1, score1.getP1());
		assertEquals(1, score1.getP2());

		score2.setP1(0);
		score2.setP2(1);
		score2 = SetRule.simpleRule(score2, 2);
		assertEquals(0, score2.getP1());
		assertEquals(2, score2.getP2());

		// 0 2 => 0 3 or 1 2
		score1.setP1(0);
		score1.setP2(2);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(1, score1.getP1());
		assertEquals(2, score1.getP2());

		score2.setP1(0);
		score2.setP2(2);
		score2 = SetRule.simpleRule(score2, 2);
		assertEquals(0, score2.getP1());
		assertEquals(3, score2.getP2());

		// etc to 6

		// if 6 vs 5 to 7
		score1.setP1(6);
		score1.setP2(5);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(7, score1.getP1());
		assertEquals(5, score1.getP2());

		score1.setP1(6);
		score1.setP2(5);
		score1 = SetRule.simpleRule(score1, 2);
		assertEquals(6, score1.getP1());
		assertEquals(6, score1.getP2());
	}

}
