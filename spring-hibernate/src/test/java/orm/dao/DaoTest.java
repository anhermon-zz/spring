package orm.dao;

import org.hibernate.HibernateException;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import orm.model.metadata.Category;

public class DaoTest {

	@Test
	public void daoTest() throws IllegalArgumentException, IllegalAccessException, HibernateException {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/config.xml")){
			GenericDao dao = context.getBean(GenericDao.class);
			System.out.println(dao.getAll(Category.class));
			
			Category test = new Category();
			test.setSite(0);
			test.setExternal(1);
			System.out.println(dao.byNaturalKeys(test));
			
			dao.saveIfAbsent(test);
			
		}
	}

}
