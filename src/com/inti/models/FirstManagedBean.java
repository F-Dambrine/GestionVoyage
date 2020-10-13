package com.inti.models;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FirstManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	
	public FirstManagedBean() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String seConnecter() {
		if(this.login.equals("boss") && this.password.equals("boss")) {
			return "hotel";
		} else {
			return "rejected";
		}
	} 
}
	