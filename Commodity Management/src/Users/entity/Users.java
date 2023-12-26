package Users.entity;

import java.io.Serializable;

public class Users implements Serializable {
	private Integer uid; // �û�id
	private String uname; // �û���
	private String password; // ����
	private Integer unumber; // �û���������
	private Double balance; // �û�������Ʒ�ļ۸�

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUnumber() {
		return unumber;
	}

	public void setUnumber(Integer unumber) {
		this.unumber = unumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Users(Integer uid, String uname, String password, Integer unumber, Double balance) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.unumber = unumber;
		this.balance = balance;
	}

	public Users(String uname, String password, Integer unumber, Double balance) {
		super();
		this.uname = uname;
		this.password = password;
		this.unumber = unumber;
		this.balance = balance;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", password=" + password + ", unumber=" + unumber
				+ ", balance=" + balance + "]";
	}

}
