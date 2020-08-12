package kataenum;

public enum GameEnum {
	LOVE("0", 0),

	FIFTEEN("15", 1),

	THIRTY("30", 2),

	FORTY("40", 3),

	ADV("ADV", 4),

	DEUCE("DEUCE", 5);

	private String value;
	private int index;

	public String toString() {
		return value;
	}

	private GameEnum(String value, int index) {
		this.value = value;
		this.setIndex(index);
	}

	public GameEnum next() {
		for (GameEnum c : GameEnum.values()) {
			if (c.getIndex() == index + 1) {
				return c;
			}
		}
		return LOVE;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
