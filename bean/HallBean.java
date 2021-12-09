package bean;

public class HallBean {

	private String h_id;
	private String h_name;
	private String h_status;
	private String h_price;
	private String ht_id;
	private boolean valid;
	
	public HallBean() {
		super();
	}
	public HallBean(String h_id, String h_name, String h_status, String h_price, String ht_id, boolean valid) {
		super();
		this.h_id = h_id;
		this.h_name = h_name;
		this.h_status = h_status;
		this.h_price = h_price;
		this.ht_id = ht_id;
		this.valid = valid;
	}
	public String getH_id() {
		return h_id;
	}
	public String getH_name() {
		return h_name;
	}
	public String getH_status() {
		return h_status;
	}
	public String getH_price() {
		return h_price;
	}
	public String getHt_id() {
		return ht_id;
	}
	public void setH_id(String h_id) {
		this.h_id = h_id;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public void setH_status(String h_status) {
		this.h_status = h_status;
	}
	public void setH_price(String h_price) {
		this.h_price = h_price;
	}
	public void setHt_id(String ht_id) {
		this.ht_id = ht_id;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
