package cui.edu.BEAN;

// Generated 2015-4-10 13:51:26 by Hibernate Tools 3.4.0.CR1

/**
 * Provide generated by hbm2java
 */
public class Provide implements java.io.Serializable {

	private int id;
	private String cname;
	private String address;
	private String linkman;
	private String linkPhone;
	private String faxes;
	private String postNum;
	private String bankNum;
	private String netAddress;
	private String emaillAddress;
	private String remark;

	public Provide() {
	}

	public Provide(int id, String cname) {
		this.id = id;
		this.cname = cname;
	}

	public Provide(int id, String cname, String address, String linkman,
			String linkPhone, String faxes, String postNum, String bankNum,
			String netAddress, String emaillAddress, String remark) {
		this.id = id;
		this.cname = cname;
		this.address = address;
		this.linkman = linkman;
		this.linkPhone = linkPhone;
		this.faxes = faxes;
		this.postNum = postNum;
		this.bankNum = bankNum;
		this.netAddress = netAddress;
		this.emaillAddress = emaillAddress;
		this.remark = remark;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	public String getFaxes() {
		return this.faxes;
	}

	public void setFaxes(String faxes) {
		this.faxes = faxes;
	}

	public String getPostNum() {
		return this.postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getBankNum() {
		return this.bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getNetAddress() {
		return this.netAddress;
	}

	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
	}

	public String getEmaillAddress() {
		return this.emaillAddress;
	}

	public void setEmaillAddress(String emaillAddress) {
		this.emaillAddress = emaillAddress;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}