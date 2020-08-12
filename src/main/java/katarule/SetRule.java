package katarule;

import katamodel.SetScore;

public class SetRule {

	public static SetScore simpleRule(SetScore now, int winner) {
		if (winner == 1) {
			int p1 = now.getP1();
			now.setP1(p1 + 1);
		} else {
			int p2 = now.getP2();
			now.setP2(p2 + 1);
		}
		return now;
	}

}
