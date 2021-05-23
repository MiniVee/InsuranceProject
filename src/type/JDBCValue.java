package type;

public enum JDBCValue {
	DRIVER("com.mysql.jdbc.Driver"),
	URL(""),
	USER(""),
	PASSWORD("");
	
	private String value;
	
	JDBCValue(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
