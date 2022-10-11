package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="custdata")
public class User {
	@Id
	@Column(name="id")
	private int  customerid;
	
	@Column(name="name")
	private String customername;
	
	@Column(name="email")
	private String customeremail;
	@Column(name="password")
	private String customerpassword;
	@Column(name="gender")
    private String customergender;
	@Column(name="country")
    private String customercountry;
	@Column(name="contactno")
    private long contactno;
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	public String getCustomergender() {
		return customergender;
	}
	public void setCustomergender(String customergender) {
		this.customergender = customergender;
	}
	public String getCustomercountry() {
		return customercountry;
	}
	public void setCustomercountry(String customercountry) {
		this.customercountry = customercountry;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	@Override
	public String toString() {
		return "User [customerid=" + customerid + ", customername=" + customername + ", customeremail=" + customeremail
				+ ", customerpassword=" + customerpassword + ", customergender=" + customergender + ", customercountry="
				+ customercountry + ", contactno=" + contactno + "]";
	}
	public Object getCustomerPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
