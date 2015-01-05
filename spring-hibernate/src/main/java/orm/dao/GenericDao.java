package orm.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;






import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository
/**
 * Generic Dao, can perform basic operations with Hibernate Entities without specific dao implementation.
 * @author Angel
 *
 */
public class GenericDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public <T> T save(final T o) {
		return (T) sessionFactory.getCurrentSession().save(o);
	}
	
	@Transactional
	public <T> T saveIfAbsent(final T o) throws IllegalArgumentException, IllegalAccessException, HibernateException {
		T inst = byNaturalKeys(o);
		if (inst != null)return inst;
		return (T) sessionFactory.getCurrentSession().save(o);
	}
	
	@Transactional
	public void delete(final Object object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	@Transactional
	public <T> T get(final Class<T> type, final Long id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}
	
	@Transactional
	public <T> T merge(final T o) {
		return (T) sessionFactory.getCurrentSession().merge(o);
	}
	@Transactional
	public <T> void saveOrUpdate(final T o) {
		sessionFactory.getCurrentSession().saveOrUpdate(o);
	}
	@Transactional
	public <T> List<T> getAll(final Class<T> type) {
		final Session session = sessionFactory.getCurrentSession();
		final Criteria crit = session.createCriteria(type);
		return crit.list();
	}
	
	@Transactional
	public <T> T byNaturalKeys(T type) throws IllegalArgumentException, IllegalAccessException, HibernateException {
		return compose(type,sessionFactory.getCurrentSession().byNaturalId(type.getClass()));
	}
	
	
	//TODO:in the absence of natural key, use primary key.
	private <T> T compose(final T instance , NaturalIdLoadAccess natural) throws IllegalArgumentException, IllegalAccessException{
		for( Field field :instance.getClass().getDeclaredFields())
			for(Annotation annotation : field.getAnnotations())
				if(isNaturalId(annotation)){
					field.setAccessible(true);
						if(field.get(instance) != null)
							natural = natural.using(field.getName(), field.get(instance));
				}
		return (T) natural.load();
		
	}
	
	private static boolean isNaturalId(Annotation annotation) {
		return annotation.annotationType().equals(org.hibernate.annotations.NaturalId.class);
	}
}