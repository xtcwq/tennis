package katarule;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import katamodel.SetScore;

class SetRuleTest {

	@Test
	void testSimple() {
		// 6 vs 0 1 2 3 4
		SetScore score1 = new SetScore(0, 0);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(1, score1.getP1());
		assertEquals(0, score1.getP2());

		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(2, score1.getP1());
		assertEquals(0, score1.getP2());

		score1 = SetRule.simpleRule(score1, 2);
		assertEquals(2, score1.getP1());
		assertEquals(1, score1.getP2());

		score1.setP1(4);
		score1.setP2(6);
		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(5, score1.getP1());
		assertEquals(6, score1.getP2());

		score1.setP1(4);
		score1.setP2(6);
		score1 = SetRule.simpleRule(score1, 2);
		assertEquals(0, score1.getP1());
		assertEquals(0, score1.getP2());

		score1.setP1(3);
		score1.setP2(6);
		score1 = SetRule.simpleRule(score1, 2);
		assertEquals(0, score1.getP1());
		assertEquals(0, score1.getP2());

		score1 = SetRule.simpleRule(score1, 1);
		assertEquals(5, score1.getP1());
		assertEquals(1, score1.getP2());

	}

	@Test
	void testSeven() {
		// 5 vs 7
	}

	// US4
	// 7 vs 6
	// 7 vs 8
	// 8 vs 10
	// 9 vs 6
	// 6 vs 3
	// 7 vs 5
	@Test
	void testTie() {
		//
	}
}
