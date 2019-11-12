package flota.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author rvs
 *
 */

public class HibernateUtil {
	private static SessionFactory factory = null;
	private static Configuration conf;

	@SuppressWarnings("unused")
	private static SessionFactory buildSessionFactory() {
		try {
			conf = new Configuration();
			conf.configure("hibernate.cfg.xml");

			factory = conf.buildSessionFactory();

			System.out.println("Config");

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
		return factory;

	}

	@SuppressWarnings("unused")
	private static SessionFactory getSessionFactory() {

		if (factory == null) {
			factory = buildSessionFactory();

		}
		return factory;
	}

}
