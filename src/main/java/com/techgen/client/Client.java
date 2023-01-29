package com.techgen.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techgen.entity.Company;
import com.techgen.entity.CompanyPrimaryKey;
import com.techgen.util.HibernateUtil;

public class Client {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;

		Session session = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();

			session = sessionFactory.getCurrentSession();

			Transaction transaction = session.getTransaction();

			transaction.begin();

			CompanyPrimaryKey companyPrimaryKey = new CompanyPrimaryKey("Accenture", "ACC-8474");
			Company company = new Company(companyPrimaryKey);
			company.setCity("Hyderabad");
			company.setStatus(true);
			
			session.persist(company);

			transaction.commit();

		} catch (HibernateException e) {

			System.out.println(e.getMessage());

		} finally {

			if (session != null) {
				session.close();
			}

			if (sessionFactory != null) {
				sessionFactory.close();
			}

		}
	}

}
