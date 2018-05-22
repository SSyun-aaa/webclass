package model;

import java.io.Serializable;

public class VotehistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String votehistoryID;
	private String userID;
	private String contentsID;
	private String contentsdataID;

	public VotehistoryBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public VotehistoryBean(String votehistoryID,String userID,String contentsID,String contentsdataID) {
		this.votehistoryID = votehistoryID;
		this.userID = userID;
		this.contentsID = contentsID;
		this.contentsdataID = contentsdataID;
	}

	public String getVotehistoryID() {
		return votehistoryID;
	}

	public void setVotehistoryID(String votehistory) {
		this.votehistoryID = votehistory;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContentsID() {
		return contentsID;
	}

	public void setContentsID(String contentsID) {
		this.contentsID = contentsID;
	}

	public String getContentsdataID() {
		return contentsdataID;
	}

	public void setContentsdataID(String contentsdataID) {
		this.contentsdataID = contentsdataID;
	}

}
