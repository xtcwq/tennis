package kataenum;

public enum SetEnum {
	ZERO("0"),
	
	FIFTEEN("15"), 
	
	THIRTY("30"),
	
	FORTY("40"),
	
	ADV("ADV"),
	
	DEUCE("DEUCE"),
	
	END("END");
	
	private String value;
	
	public String toString() {
		return value;
	}
	
	SetEnum(String value) {
	this.value=value;
	}
}
