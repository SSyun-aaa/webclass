
package model;

import java.io.Serializable;

public class PasswordBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userID;
	private String password;

	public PasswordBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public PasswordBean(String userID,String password) {
		this.setUserID(userID);
		this.setPassword(password);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

