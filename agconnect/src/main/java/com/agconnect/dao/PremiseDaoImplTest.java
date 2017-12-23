package com.agconnect.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agconnect.entity.Premise;

@Repository
public class PremiseDaoImplTest implements PremiseDao {

	private SessionFactory sessionFactory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Premise.class)
			.buildSessionFactory();

	public List<Premise> getPremiseDataList(int a) {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.beginTransaction();

		Query<Premise> getPremisesQuery = currentSession.createQuery("from Premise p where p.premiseID = :id", Premise.class);
		
		getPremisesQuery.setInteger("id", a);
		
		List<Premise> premises = getPremisesQuery.getResultList();
		
		System.out.println(premises);
		
		System.out.println(currentSession.get(Premise.class, 2001));

		currentSession.close();

		return null;
	}

	public static void main(String []args) {
		PremiseDaoImplTest p = new PremiseDaoImplTest();
		p.getPremiseDataList();
	}

	public List<Premise> getPremiseDataList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Premise> getPremises() {
		// TODO Auto-generated method stub
		return null;
	}
}


