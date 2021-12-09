package bean;

public class CustBean {
	
	private String c_id;
	private String c_name;
	private String c_phone;
	private String c_address;
	private String c_zipcode;
	private String c_city;
	private boolean valid;
	
	public CustBean() {
		super();
	}
	public CustBean(String c_id, String c_name, String c_phone, String c_address, String c_zipcode, String c_city,
			boolean valid) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_phone = c_phone;
		this.c_address = c_address;
		this.c_zipcode = c_zipcode;
		this.c_city = c_city;
		this.valid = valid;
	}
	public String getC_id() {
		return c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public String getC_phone() {
		return c_phone;
	}
	public String getC_address() {
		return c_address;
	}
	public String getC_zipcode() {
		return c_zipcode;
	}
	public String getC_city() {
		return c_city;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public void setC_zipcode(String c_zipcode) {
		this.c_zipcode = c_zipcode;
	}
	public void setC_city(String c_city) {
		this.c_city = c_city;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}