package com.sohan.hibernate.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class LoginName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ssn;
	private String userId;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
