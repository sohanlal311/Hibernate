package com.sohan.hibernate.dto;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
// @Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Vehicle.byId", query = "from Vehicle where id > ?")
@NamedNativeQuery(name = "Vehicle.byName", query = "select * from vehicle where vehicle_name = ?", resultClass = Vehicle.class)
// @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType =
// DiscriminatorType.STRING)
// @DiscriminatorValue("Veh")
public class Vehicle {

	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int id;

	@Column(name = "VEHICLE_NAME")
	private String name;

	// @ManyToOne
	// @JoinColumn(name = "USER_ID")
	// @NotFound(action = NotFoundAction.IGNORE)
	// private UserDetails userDetails;

	// @ManyToMany(mappedBy = "vehicles")
	// private Collection<UserDetails> userDetails = new
	// ArrayList<UserDetails>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public UserDetails getUserDetails() {
	// return userDetails;
	// }
	//
	// public void setUserDetails(UserDetails userDetails) {
	// this.userDetails = userDetails;
	// }

	// public Collection<UserDetails> getUserDetails() {
	// return userDetails;
	// }
	//
	// public void setUserDetails(Collection<UserDetails> userDetails) {
	// this.userDetails = userDetails;
	// }

}
