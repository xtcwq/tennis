package katamodel;

import kataenum.GameEnum;

public class GameScore {
	private GameEnum p1;
	private GameEnum p2;

	public GameScore(GameEnum p1, GameEnum p2) {
		this.setP1(p1);
		this.setP2(p2);
	}

	public GameEnum getP1() {
		return p1;
	}

	public void setP1(GameEnum p1) {
		this.p1 = p1;
	}

	public GameEnum getP2() {
		return p2;
	}

	public void setP2(GameEnum p2) {
		this.p2 = p2;
	}
}
