package type;

public enum JDBCValue {
	DRIVER("com.mysql.cj.jdbc.Driver"),
	URL("jdbc:mysql://localhost:3307/insuranceproject?&useSSL=false&serverTimezone=UTC"),
	USER("root"),
	PASSWORD("5395");
	
	private String value;
	
	JDBCValue(String value){
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}