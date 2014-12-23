package home.db.dao.imp;

import home.db.dao.HibernateDao;
import home.db.orm.model.Category;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao extends HibernateDao<Category> {

	@Override
	public Category getById(long id) {
		String hql   = "from Category where :id=1";
		return (Category) getSessionFactory().openSession().createQuery(hql).setLong("id", id).uniqueResult();
	}
	
	@Override
	public List<Category> getAll() {
		String hql   = "from Category";
		return getSessionFactory().openSession().createQuery(hql).list();
	}

}
