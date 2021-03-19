package shopDB;

import java.sql.Timestamp;

public class ShopDataBean {

	private String name;
	private String id;
	private String passwd;
	private String tel;
	private Timestamp rag_date;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Timestamp getRag_date() {
		return rag_date;
	}
	public void setRag_date(Timestamp rag_date) {
		this.rag_date = rag_date;
	}
	
	
}
