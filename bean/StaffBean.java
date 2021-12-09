package bean;

public class StaffBean {

	private int s_id;
	private String s_FName;
	private String s_LName;
	private String s_no;
	private String s_pass;
	private String st_id;
	public boolean valid;
	
	public StaffBean() {
		super();
	}
	public StaffBean(int s_id, String s_FName, String s_LName, String s_no, String s_pass, String st_id, boolean valid) {
		super();
		this.s_id = s_id;
		this.s_no = s_no;
		this.s_pass = s_pass;
		this.s_FName = s_FName;
		this.s_LName = s_LName;
		this.st_id = st_id;
		this.valid = valid;
	}
	public int getS_id() {
		return s_id;
	}
	public String getS_no() {
		return s_no;
	}
	public String getS_pass() {
		return s_pass;
	}
	public String getS_FName() {
		return s_FName;
	}
	public String getS_LName() {
		return s_LName;
	}
	public String getSt_id() {
		return st_id;
	}
	public boolean isValid() {
		return valid;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public void setS_no(String s_no) {
		this.s_no = s_no;
	}
	public void setS_pass(String s_pass) {
		this.s_pass = s_pass;
	}
	public void setS_FName(String s_FName) {
		this.s_FName = s_FName;
	}
	public void setS_LName(String s_LName) {
		this.s_LName = s_LName;
	}
	public void setSt_id(String st_id) {
		this.st_id = st_id;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}	
}