package com.domogreen.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {

			// para hibernate 4.3
			

			// Configuration configuration = new
			// Configuration().Configure("hibernate.cfg.xml");
			// return configuration.buildSessionFactory (new
			// StandardServiceRegistryBuilder().applySetting( configuration.getProperties()
			// ).build() );

			// para hibernate 5
			// desde un archivo de configuracion

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			;
			Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			return metadata.getSessionFactoryBuilder().build();

		} catch (Exception e) {

			System.err.print("fallo connection sessionFactory" + e);
			throw new ExceptionInInitializerError(e);

		}

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
