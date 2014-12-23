package home;

import home.db.dao.HibernateDao;
import home.db.dao.imp.CategoryDao;
import home.db.orm.model.Category;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring.xml")){
			HibernateDao<Category> hd = initBean(ctx);
			System.out.println(hd.getAll());
			System.out.println(hd.getById(2L));
		}

	}

	private static HibernateDao initBean(ClassPathXmlApplicationContext ctx) {
		return ctx.getBean("categoryDao",CategoryDao.class);
	}

}
