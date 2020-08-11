package katarule;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class SetRuleTest extends TestCase {

	// US1

	// 0 0 => 0 15

	// 0 15 => 15 15 or 0 30

	// 0 30 => 0 40 or 15 30

	// 0 40 => 15 40 or end

	// 15 15 => 15 30

	// 15 30 => 15 40 or 30 30

	// 15 40 => 30 40 or end

	// 30 30 => 30 40

	// 30 40 =>40 40 or end

	@Test
	void testSimpleRule() {
	}

	// US2
	// 40 40 => 40 ADV

	// 40 ADV => DEUCE or end

	// DEUCE => 40 ADV

	@Test
	void testDeuseRule() {
	}

	// US4
	// 7 vs 6
	// 7 vs 8
	// 8 vs 10
	// 9 vs 6
	// 6 vs 3
	// 7 vs 5
	@Test
	void testTieRule() {
	}

}
