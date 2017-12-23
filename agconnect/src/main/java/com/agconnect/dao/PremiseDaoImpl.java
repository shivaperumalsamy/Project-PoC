package com.agconnect.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.agconnect.entity.Premise;

@Repository
public class PremiseDaoImpl implements PremiseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Premise> getPremises() {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.beginTransaction();

		Query<Premise> getPremisesQuery = currentSession.createQuery("from Premise", Premise.class);

		List<Premise> premises = getPremisesQuery.getResultList();

		currentSession.close();

		return premises;
	}
}



