package home.db.dao.imp;

import home.db.dao.HibernateDao;
import home.db.orm.model.Category;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
/**
 * Toturial for HQL: <a href="https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/queryhql.html#queryhql-where">link</a>
 * @author Angel
 *
 */


@Repository(value = "categoryDao")
public class CategoryDao extends HibernateDao<Category> {

	@Override
	public List<Category> findAll() {
		return getSessionFactory().getCurrentSession().createQuery("from Category c").list();
	}

	@Override
	public Category byId(long id) {
		String hql   = "from Category where :id=1";
		return (Category) getSessionFactory().openSession().createQuery(hql).setLong("id", id).uniqueResult();
	}

	@Override
	public void delete(Category category) {
		getSessionFactory().getCurrentSession().delete(category);
	}
   


}
