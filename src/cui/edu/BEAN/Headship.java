package cui.edu.BEAN;

// Generated 2015-4-10 13:51:26 by Hibernate Tools 3.4.0.CR1

/**
 * Headship generated by hbm2java
 */
public class Headship implements java.io.Serializable {

	private int id;
	private String headshipName;

	public Headship() {
	}

	public Headship(int id) {
		this.id = id;
	}

	public Headship(int id, String headshipName) {
		this.id = id;
		this.headshipName = headshipName;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeadshipName() {
		return this.headshipName;
	}

	public void setHeadshipName(String headshipName) {
		this.headshipName = headshipName;
	}

}
