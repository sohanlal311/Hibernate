package com.sohan.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.sohan.hibernate.dto.FourWheeler;
import com.sohan.hibernate.dto.TwoWheeler;
import com.sohan.hibernate.dto.Vehicle;

public class HibernateTest1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// oldMain();
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// Query query = session.createQuery("select max(id) from Vehicle");
		// Query query = session.getNamedQuery("Vehicle.byId");
		// Query query = session.getNamedQuery("Vehicle.byName");
		// query.setString(0, "V15");
		// List<Vehicle> list = (List<Vehicle>) query.list();
		Vehicle exampleVehicle = new Vehicle();
		//exampleVehicle.setId(12);
		//exampleVehicle.setName("V12");
		exampleVehicle.setName("V1%");
		Example example = Example.create(exampleVehicle).enableLike();//.excludeProperty("name");
		Criteria criteria = session.createCriteria(Vehicle.class).add(example);
				//.setProjection(Projections.count("name"));
				//.addOrder(Order.desc("id"));
		// criteria.add(Restrictions.like("name", "V1%")).add(
		// Restrictions.gt("id", 13));
		criteria.add(Restrictions.or(Restrictions.like("name", "V1%"),
				Restrictions.between("id", 2, 5)));
		List<Vehicle> list = (List<Vehicle>) criteria.list();
		//List<Long> list = (List<Long>) criteria.list();
		session.getTransaction().commit();
		session.close();
		for (Vehicle v : list) {
			System.out.println(v.getName());
		}

	}

	private static void oldMain() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Car");

		TwoWheeler pulsar = new TwoWheeler();
		pulsar.setName("Pulsar");
		pulsar.setSteeringHandle("Pulsar Steering Handle");

		FourWheeler porche = new FourWheeler();
		porche.setName("Porche");
		porche.setSteeringHandle("Porche Steering Wheel");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(pulsar);
		session.save(porche);
		session.getTransaction().commit();
		session.close();
	}
}
