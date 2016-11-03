package com.sohan.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	// @EmbeddedId
	// private LoginName loginName;

	// @Transient
	private String userName;

	// @Embedded
	// @AttributeOverrides({
	// @AttributeOverride(name = "street", column = @Column(name =
	// "HOME_STREET_NAME")),
	// @AttributeOverride(name = "city", column = @Column(name =
	// "HOME_CITY_NAME")),
	// @AttributeOverride(name = "state", column = @Column(name =
	// "HOME_STATE_NAME")),
	// @AttributeOverride(name = "pincode", column = @Column(name =
	// "HOME_PIN_CODE")) })
	// private Address homeAddress;
	//
	// @Embedded
	// private Address officeAddress;

	@ElementCollection(fetch = FetchType.EAGER)
	// @CollectionTable(name = "USER_ADDRESS",
	// joinColumns=@JoinColumn(name="USER_ID"))
	@JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new HashSet<Address>();
	// private Set<Address> listOfAddresses = new HashSet<Address>();

	@Lob
	private String description;

	// @OneToOne
	// @JoinColumn(name = "VEHICLE_ID")
	// private Vehicle vehicle;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @OneToMany(mappedBy = "userDetails", fetch = FetchType.EAGER)
	// @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Temporal(TemporalType.DATE)
	private Date joiningDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	// public LoginName getLoginName() {
	// return loginName;
	// }
	//
	// public void setLoginName(LoginName loginName) {
	// this.loginName = loginName;
	// }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	// public Address getHomeAddress() {
	// return homeAddress;
	// }
	//
	// public void setHomeAddress(Address homeAddress) {
	// this.homeAddress = homeAddress;
	// }
	//
	// public Address getOfficeAddress() {
	// return officeAddress;
	// }
	//
	// public void setOfficeAddress(Address officeAddress) {
	// this.officeAddress = officeAddress;
	// }

	// public Set<Address> getListOfAddresses() {
	// return listOfAddresses;
	// }
	//
	// public void setListOfAddresses(Set<Address> listOfAddresses) {
	// this.listOfAddresses = listOfAddresses;
	// }

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	// public Vehicle getVehicle() {
	// return vehicle;
	// }
	//
	// public void setVehicle(Vehicle vehicle) {
	// this.vehicle = vehicle;
	// }

	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public boolean addVehicle(Vehicle vehicle) {
		boolean result = false;
		if (vehicles == null) {
			vehicles = new ArrayList<Vehicle>();
		}
		vehicles.add(vehicle);
		// vehicle.setUserDetails(this);
		// vehicle.getUserDetails().add(this);
		return result;
	}

}
