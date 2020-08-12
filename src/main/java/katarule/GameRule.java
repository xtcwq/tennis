package katarule;

import kataenum.GameEnum;
import katamodel.GameScore;
import katamodel.TieScore;

//SPRINT1

public class GameRule {

	public static GameScore chooseRule(GameScore now, int winner) {
		if (now.getP1().getIndex() + now.getP2().getIndex() > 5)
			return deuseRule(now, winner);
		return simpleRule(now, winner);
	}

	public static GameScore simpleRule(GameScore now, int winner) {
		GameEnum p1 = now.getP1();
		GameEnum p2 = now.getP2();
		GameScore newS = new GameScore(p1, p2);
		if (winner == 1) {
			newS.setP1(p1.next());
		} else {
			newS.setP2(p2.next());
		}

		// end
		if (newS.getP1().getIndex() == 4 || newS.getP2().getIndex() == 4) {
			newS.setP1(GameEnum.LOVE);
			newS.setP2(GameEnum.LOVE);
		}
		return newS;
	}

	public static GameScore deuseRule(GameScore now, int winner) {
		GameEnum p1 = now.getP1();
		GameEnum p2 = now.getP2();
		GameScore newS = new GameScore(p1, p2);
		// 40 40 or DEUSE
		if (p1.getIndex() == p2.getIndex()) {
			if (winner == 1) {
				newS.setP1(GameEnum.ADV);
				newS.setP2(GameEnum.FORTY);
			} else {
				newS.setP2(GameEnum.ADV);
				newS.setP1(GameEnum.FORTY);
			}
		} else if ((p1.getIndex() > p2.getIndex() && winner == 1) || (p1.getIndex() < p2.getIndex() && winner == 2)) {
			newS.setP1(GameEnum.LOVE);
			newS.setP2(GameEnum.LOVE);
		} else {
			newS.setP1(GameEnum.DEUCE);
			newS.setP2(GameEnum.DEUCE);
		}
		return newS;
	}

	public static TieScore tieRule(TieScore tienow, int winner) {
		int p1 = tienow.getP1();
		int p2 = tienow.getP2();
		TieScore newT = new TieScore(p1, p2);
		if (winner == 1) {
			newT.setP1(p1 + 1);
		} else {
			newT.setP2(p2 + 1);
		}
		if ((newT.getP1() > 6 || newT.getP2() > 6) && Math.abs(newT.getP1() - newT.getP2()) > 1) {
			newT.setP1(0);
			newT.setP2(0);
		}
		return newT;
	}

}
