package model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class ContentsdataBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String contentsID;
	private String contentsdataID;
	private String contentsdataName;
	private Blob contentsdataPicture;
	private String introduction;
	private String sex;
	private Date birthday;

	public ContentsdataBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ContentsdataBean(String contentsID,String contentsdataID,String contentsdataName,Blob contentsdataPicture,String introduction,String sex,Date birthday) {
		this.contentsID = contentsID;
		this.contentsdataID = contentsdataID;
		this.contentsdataName = contentsdataName;
		this.contentsdataPicture = contentsdataPicture;
		this.introduction = introduction;
		this.sex = sex;
		this.birthday = birthday;
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
	public String getContentsdataName() {
		return contentsdataName;
	}
	public void setContentsdataName(String contentsdataName) {
		this.contentsdataName = contentsdataName;
	}
	public Blob getContentsdataPicture() {
		return contentsdataPicture;
	}
	public void setContentsdataPicture(Blob contentsdataPicture) {
		this.contentsdataPicture = contentsdataPicture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
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
