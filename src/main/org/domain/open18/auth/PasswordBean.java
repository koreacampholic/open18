package org.domain.open18.auth;

import org.jboss.seam.annotations.Name;

@Name("passwordBean")
public class PasswordBean {
	private String password;
	private String confirm;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	public boolean verify() {
		return confirm != null && confirm.equals(password);
	}
	
}
