package com.sohan.hibernate.dto;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
