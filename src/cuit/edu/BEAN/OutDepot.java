package cuit.edu.BEAN;

// Generated 2015-4-13 10:16:12 by Hibernate Tools 3.4.0.CR1

/**
 * OutDepot generated by hbm2java
 */
public class OutDepot implements java.io.Serializable {

	private int id;
	private Integer did;
	private String wname;
	private String outDate;
	private Float wight;
	private String remark;

	public OutDepot() {
	}

	public OutDepot(int id) {
		this.id = id;
	}

	public OutDepot(int id, Integer did, String wname, String outDate,
			Float wight, String remark) {
		this.id = id;
		this.did = did;
		this.wname = wname;
		this.outDate = outDate;
		this.wight = wight;
		this.remark = remark;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getDid() {
		return this.did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

	public String getOutDate() {
		return this.outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public Float getWight() {
		return this.wight;
	}

	public void setWight(Float wight) {
		this.wight = wight;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
