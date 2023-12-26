package Users.entity;

import java.io.Serializable;

public class Users implements Serializable {
	private Integer uid; // 用户id
	private String uname; // 用户名
	private String password; // 密码
	private Integer unumber; // 用户购买数量
	private Double balance; // 用户购买商品的价格

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
