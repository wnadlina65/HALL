package bean;

public class BookBean {
	
	private String bk_id;
	private String bk_name;
	private String bk_strdate;
	private String bk_enddate;
	private String bk_pax;
	private String bk_totprice;
	private String c_id;
	private String h_id;
	private boolean valid;
	
	public BookBean() {
		super();
	}
	public BookBean(String bk_id, String bk_name, String bk_strdate, String bk_enddate, String bk_pax,
			String bk_totprice, String c_id, String h_id, boolean valid) {
		super();
		this.bk_id = bk_id;
		this.bk_name = bk_name;
		this.bk_strdate = bk_strdate;
		this.bk_enddate = bk_enddate;
		this.bk_pax = bk_pax;
		this.bk_totprice = bk_totprice;
		this.c_id = c_id;
		this.h_id = h_id;
		this.valid = valid;
	}
	public String getBk_id() {
		return bk_id;
	}
	public String getBk_name() {
		return bk_name;
	}
	public String getBk_strdate() {
		return bk_strdate;
	}
	public String getBk_enddate() {
		return bk_enddate;
	}
	public String getBk_pax() {
		return bk_pax;
	}
	public String getBk_totprice() {
		return bk_totprice;
	}
	public String getC_id() {
		return c_id;
	}
	public String getH_id() {
		return h_id;
	}
	public boolean isValid() {
		return valid;
	}
	public void setBk_id(String i) {
		this.bk_id = i;
	}
	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}
	public void setBk_strdate(String bk_strdate) {
		this.bk_strdate = bk_strdate;
	}
	public void setBk_enddate(String bk_enddate) {
		this.bk_enddate = bk_enddate;
	}
	public void setBk_pax(String bk_pax) {
		this.bk_pax = bk_pax;
	}
	public void setBk_totprice(String bk_totprice) {
		this.bk_totprice = bk_totprice;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public void setH_id(String h_id) {
		this.h_id = h_id;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
