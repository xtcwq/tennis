package katamodel;

public class TieScore {
	private int p1;
	private int p2;

	public TieScore(int v1, int v2) {
		setP1(v1);
		setP2(v2);
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

}
