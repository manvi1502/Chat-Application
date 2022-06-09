package com.Manvi.chatapp.dto;

public class UserDTO {
	String userid;
	char[] password;
	String email;
	String contact;
	String city;
	public UserDTO(String userid,char[] password,String email,String contact,String city) {
		this.userid=userid;
		this.password=password;
		this.email=email;
		this.contact=contact;
		this.city=city;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city= city;
	}

	

}
