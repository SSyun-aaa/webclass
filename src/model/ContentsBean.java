package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;


public class ContentsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String contentsID;
	private String contentsName;
	private Date contentsDate;
	private Date startDate;
	private Date endDate;
	private Blob contentsPicture;

	public ContentsBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public ContentsBean(String contentsID,String contentsName,Date contentsDate,Date startDate,Date endDate,Blob contentsPicture) {
		this.setContentsID(contentsID);
		this.setContentsName(contentsName);
		this.setContentsDate(contentsDate);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setContentsPicture(contentsPicture);
	}

	public String getContentsID() {
		return contentsID;
	}

	public void setContentsID(String contentsID) {
		this.contentsID = contentsID;
	}

	public String getContentsName() {
		return contentsName;
	}

	public void setContentsName(String contentsName) {
		this.contentsName = contentsName;
	}

	public Date getContentsDate() {
		return contentsDate;
	}

	public void setContentsDate(Date contentsDate) {
		this.contentsDate = contentsDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Blob getContentsPicture() {
		return contentsPicture;
	}

	public void setContentsPicture(Blob contentsPicture) {
		this.contentsPicture = contentsPicture;
	}

}
