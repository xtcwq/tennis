package katarule;

import kataenum.GameEnum;
import katamodel.GameScore;

//SPRINT1

public class GameRule {

	public static GameScore chooseRule(GameScore now, int winner) {
		if (now.getP1().getIndex() + now.getP2().getIndex() > 5)
			return deuseRule(now, winner);
		return simpleRule(now, winner);
	}

	public static GameScore simpleRule(GameScore now, int winner) {
		if (winner == 1) {
			GameEnum p1 = now.getP1();
			now.setP1(p1.next());
		} else {
			GameEnum p2 = now.getP2();
			now.setP2(p2.next());
		}

		// end
		if (now.getP1().getIndex() == 4 || now.getP2().getIndex() == 4) {
			now.setP1(GameEnum.LOVE);
			now.setP2(GameEnum.LOVE);
		}
		return now;
	}

	public static GameScore deuseRule(GameScore now, int winner) {
		GameEnum p1 = now.getP1();
		GameEnum p2 = now.getP2();
		// 40 40 or DEUSE
		if (p1.getIndex() == p2.getIndex()) {
			if (winner == 1) {
				now.setP1(GameEnum.ADV);
				now.setP2(GameEnum.FORTY);
			} else {
				now.setP2(GameEnum.ADV);
				now.setP1(GameEnum.FORTY);
			}
		} else if ((p1.getIndex() > p2.getIndex() && winner == 1) || (p1.getIndex() < p2.getIndex() && winner == 2)) {
			now.setP1(GameEnum.LOVE);
			now.setP2(GameEnum.LOVE);
		} else {
			now.setP1(GameEnum.DEUCE);
			now.setP2(GameEnum.DEUCE);
		}
		return now;
	}

}
