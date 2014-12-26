package home;

import home.db.dao.HibernateDao;
import home.db.dao.imp.CategoryDao;
import home.db.orm.model.Attribute;
import home.db.orm.model.Category;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) throws SQLException {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring.xml")){
			HibernateDao hd = null;
			
			hd= ctx.getBean("categoryDao",CategoryDao.class);
			Category c = new Category();
			Attribute a = new Attribute();
			a.setName("Brand");
			c.setExternal(1);
			c.setSite(0);
			c.addAttribute(a);
			try {
				hd.save(c);
			} catch (ConstraintViolationException e) {
				System.out.println("Warning! constraint violation exception occured!\nConstraint Name:" + e.getConstraintName());
			}
			List<Category> all = hd.findAll();
			for(Category category : all){
				hd.delete(category);
				System.out.println(hd.findAll());
				hd.save(category);
				System.out.println(hd.findAll());
			}
			
			
		}

	}

}
