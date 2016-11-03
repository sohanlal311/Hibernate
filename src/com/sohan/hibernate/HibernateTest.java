package com.sohan.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sohan.hibernate.dto.Address;
import com.sohan.hibernate.dto.UserDetails;
import com.sohan.hibernate.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		// oldMain();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("User pulled is: " + user.getUserName());
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("User pulled is: " + user.getUserName());
	}

	private static void oldMain() {
		UserDetails user = new UserDetails();
		// user.setUserId(1);
		// LoginName loginName1 = new LoginName();
		// loginName1.setSsn("0311");
		// loginName1.setUserId("sohanece");
		// user.setLoginName(loginName1);
		user.setUserName("Sohan");
		user.setJoiningDate(new Date());
		user.setDescription("description1");
		Address homeAddr1 = new Address();
		homeAddr1.setStreet("Ambika Tower");
		homeAddr1.setCity("Mumbai");
		homeAddr1.setState("Maharashtra");
		// user.setHomeAddress(homeAddr1);
		Address officeAddr1 = new Address();
		officeAddr1.setStreet("Raheja Titanium");
		officeAddr1.setCity("Mumbai");
		officeAddr1.setState("Maharashtra");
		// user.setOfficeAddress(officeAddr1);
		user.getListOfAddresses().add(homeAddr1);
		user.getListOfAddresses().add(officeAddr1);
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setName("Honda City");
		// user.getVehicles().add(vehicle1);
		user.addVehicle(vehicle1);
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setName("Honda Civic");
		// user.getVehicles().add(vehicle2);
		user.addVehicle(vehicle2);

		UserDetails user2 = new UserDetails();
		// LoginName loginName2 = new LoginName();
		// loginName2.setSsn("2512");
		// loginName2.setUserId("sohanece");
		// user2.setLoginName(loginName2);
		user2.setUserName("Sonu");
		user2.setJoiningDate(new Date());
		user2.setDescription("description2");

		Address homeAddr2 = new Address();
		homeAddr2.setStreet("Jawahar Nagar");
		homeAddr2.setCity("Ajmer");
		homeAddr2.setState("Rajasthan");
		// user2.setHomeAddress(homeAddr2);
		Address officeAddr2 = new Address();
		officeAddr2.setStreet("Future Marathon");
		officeAddr2.setCity("Mumbai");
		officeAddr2.setState("Maharashtra");
		// user2.setOfficeAddress(officeAddr2);
		user2.getListOfAddresses().add(homeAddr2);
		user2.getListOfAddresses().add(officeAddr2);

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setName("Audi Q4");
		// user2.getVehicles().add(vehicle3);
		user2.addVehicle(vehicle3);
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setName("Audi A3");
		// user2.getVehicles().add(vehicle4);
		user2.addVehicle(vehicle4);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		// session.save(user);
		// session.save(vehicle1);
		// session.save(vehicle2);
		session.persist(user2);
		// session.save(user2);
		// session.save(vehicle3);
		// session.save(vehicle4);
		session.getTransaction().commit();
		session.close();

		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		Vehicle veh = (Vehicle) session.get(Vehicle.class, 3);
		session.close();
		System.out.println("Addresses : " + user.getListOfAddresses().size());
		System.out.println("Vehicles: " + user.getVehicles().size());
		for (Vehicle vehicle : user.getVehicles()) {
			System.out.println("Vehicle #" + vehicle.getId());
		}
		System.out.println("User name is " + user.getUserName());
		// System.out.println("Vehicle #" + veh.getId() + " is with user "
		// + veh.getUserDetails());
	}
}
