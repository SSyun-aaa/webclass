package model;

import java.io.Serializable;
import java.sql.Date;
//java.util.Date?

public class UserBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
	private String userName;
	private Date createDate;
	private String authority;
	private String sex;
	private Date birthday;

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public UserBean(String userID,String userName,Date createDate,String authority,String sex,Date birthday) {
		this.userID = userID;
		this.userName = userName;
		this.createDate = createDate;
		this.authority = authority;
		this.sex = sex;
		this.birthday = birthday;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
