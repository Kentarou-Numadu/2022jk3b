package bean;

import java.io.Serializable;
import java.sql.Date;

public class DataBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String furigana;
	private Date birth_day;
	private String zip_code;
	private String address;
	private String telephone;
	private String mail;
	private int status;
	private Date status_day;
	private String p_name;
	private String p_furigana;
	private String p_zip;
	private String p_address;
	private String p_telephone;
	private String p_mail;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}
	
	public void setBirth(Date birth_day) {
		this.birth_day = birth_day;
	}
	
	public void setZip(String zip_code) {
		this.zip_code = zip_code;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setStatus_day(Date status_day2) {
		this.status_day = status_day2;
	}
	
	public void setP_Name(String p_name) {
		this.p_name = p_name;
	}
	
	public void setP_Furigana(String p_furigana) {
		this.p_furigana = p_furigana;
	}
	
	public void setP_Zip(String p_zip) {
		this.p_zip = p_zip;
	}
	
	public void setP_Address(String p_address) {
		this.p_address = p_address;
	}
	
	public void setP_Telephone(String p_telephone) {
		this.p_telephone = p_telephone;
	}
	
	public void setP_Mail(String p_mail) {
		this.p_mail = p_mail;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getFurigana() {
		return this.furigana;
	}
	
	public Date getBirth() {
		return this.birth_day;
	}
	
	public String getZip() {
		return this.zip_code;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public String getP_Name() {
		return this.p_name;
	}
	
	public Date getStatus_day() {
		return this.status_day;
	}
	
	public String getP_Furigana() {
		return this.p_furigana;
	}
	
	public String getP_Zip() {
		return this.p_zip;
	}
	
	public String getP_Address() {
		return this.p_address;
	}
	
	public String getP_Telephone() {
		return this.p_telephone;
	}
	
	public String getP_Mail() {
		return this.p_mail;
	}
	
	

}
