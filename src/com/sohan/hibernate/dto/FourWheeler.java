package com.sohan.hibernate.dto;

import javax.persistence.Entity;

@Entity
// @DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
	private String steeringWheel;

	public String getSteeringHandle() {
		return steeringWheel;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringWheel = steeringHandle;
	}

}
