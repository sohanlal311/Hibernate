package com.sohan.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sohan.hibernate.dto.Vehicle;

public class HIbernateTest2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Vehicle vehicle = (Vehicle) session.get(Vehicle.class, 12);
		// vehicle.setName("V12 Updated");
		// Vehicle vehicle2 = (Vehicle) session.get(Vehicle.class, 12);
		Query qry = session.createQuery("from Vehicle where id = 12");
		qry.setCacheable(true);
		List<Vehicle> list = (List<Vehicle>) qry.list();
		session.getTransaction().commit();
		session.close();
		//System.out.println(vehicle.getName());
		System.out.println(list.get(0).getName());

		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		//Vehicle vehicle2 = (Vehicle) session2.get(Vehicle.class, 12);
		Query qry2 = session2.createQuery("from Vehicle where id = 12");
		qry2.setCacheable(true);
		List<Vehicle> list2 = (List<Vehicle>) qry2.list();
		session2.getTransaction().commit();
		session2.close();
		//System.out.println(vehicle2.getName());
		System.out.println(list2.get(0).getName());
	}
}
