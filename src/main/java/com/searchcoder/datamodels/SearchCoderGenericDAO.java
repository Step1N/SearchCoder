package com.searchcoder.datamodels;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Filter;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public abstract class SearchCoderGenericDAO extends HibernateDaoSupport {

	final static Logger logger = Logger.getLogger(SearchCoderGenericDAO.class);
	
	public <T> T execute(HibernateCallback<T> action)
			throws DataAccessException {

		return getHibernateTemplate().execute(action);
	}

	public <T> T get(Class<T> entityClass, Serializable id)
			throws DataAccessException {

		return getHibernateTemplate().get(entityClass, id);
	}

	public <T> T get(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException {

		return getHibernateTemplate().get(entityClass, id, lockMode);
	}

	public Object get(String entityName, Serializable id)
			throws DataAccessException {

		return null;
	}

	public Object get(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException {

		return getHibernateTemplate().get(entityName, id, lockMode);
	}

	public <T> T load(Class<T> entityClass, Serializable id)
			throws DataAccessException {

		return getHibernateTemplate().load(entityClass, id);
	}

	public <T> T load(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException {

		return getHibernateTemplate().load(entityClass, id, lockMode);
	}

	public Object load(String entityName, Serializable id)
			throws DataAccessException {

		return getHibernateTemplate().load(entityName, id);
	}

	public Object load(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException {

		return getHibernateTemplate().load(entityName, id, lockMode);
	}

	public <T> List<T> loadAll(Class<T> entityClass) throws DataAccessException {

		return getHibernateTemplate().loadAll(entityClass);
	}

	public void load(Object entity, Serializable id) throws DataAccessException {

		getHibernateTemplate().load(entity, id);
	}

	public void refresh(Object entity) throws DataAccessException {

		getHibernateTemplate().refresh(entity);
	}

	public void refresh(Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().refresh(entity, lockMode);
	}

	public boolean contains(Object entity) throws DataAccessException {

		return getHibernateTemplate().contains(entity);
	}

	public void evict(Object entity) throws DataAccessException {

		getHibernateTemplate().evict(entity);
	}

	public void initialize(Object proxy) throws DataAccessException {

		getHibernateTemplate().initialize(proxy);
	}

	public Filter enableFilter(String filterName) throws IllegalStateException {

		return getHibernateTemplate().enableFilter(filterName);
	}

	public void lock(Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().lock(entity, lockMode);
	}

	public void lock(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().lock(entityName, entity, lockMode);
	}

	public Serializable save(Object entity) throws DataAccessException {

		return getHibernateTemplate().save(entity);
	}

	public Serializable save(String entityName, Object entity)
			throws DataAccessException {

		return getHibernateTemplate().save(entityName, entity);
	}

	public void update(Object entity) throws DataAccessException {

		getHibernateTemplate().update(entity);
	}

	public void update(Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().update(entity, lockMode);
	}

	public void update(String entityName, Object entity)
			throws DataAccessException {

		getHibernateTemplate().update(entityName, entity);
	}

	public void update(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().update(entityName, entity, lockMode);
	}

	public void saveOrUpdate(Object entity) throws DataAccessException {

		getHibernateTemplate().saveOrUpdate(entity);
	}

	public void saveOrUpdate(String entityName, Object entity)
			throws DataAccessException {

		getHibernateTemplate().saveOrUpdate(entityName, entity);
	}

	public void replicate(Object entity, ReplicationMode replicationMode)
			throws DataAccessException {

		getHibernateTemplate().replicate(entity, replicationMode);
	}

	public void replicate(String entityName, Object entity,
			ReplicationMode replicationMode) throws DataAccessException {

		getHibernateTemplate().replicate(entityName, entity, replicationMode);
	}

	public void persist(Object entity) throws DataAccessException {

		getHibernateTemplate().persist(entity);
	}

	public void persist(String entityName, Object entity)
			throws DataAccessException {

		getHibernateTemplate().persist(entityName, entity);
	}

	public <T> T merge(T entity) throws DataAccessException {

		return getHibernateTemplate().merge(entity);
	}

	public <T> T merge(String entityName, T entity) throws DataAccessException {

		return getHibernateTemplate().merge(entityName, entity);
	}

	public void delete(Object entity) throws DataAccessException {

		getHibernateTemplate().delete(entity);
	}

	public void delete(Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().delete(entity, lockMode);
	}

	public void delete(String entityName, Object entity)
			throws DataAccessException {

		getHibernateTemplate().delete(entityName, entity);
	}

	public void delete(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException {

		getHibernateTemplate().delete(entityName, entity, lockMode);
	}

	public void deleteAll(Collection<?> entities) throws DataAccessException {

		getHibernateTemplate().deleteAll(entities);
	}

	public void flush() throws DataAccessException {

		getHibernateTemplate().flush();
	}

	public void clear() throws DataAccessException {

		getHibernateTemplate().clear();
	}

	public List<?> find(String queryString, Object... values)
			throws DataAccessException {

		return getHibernateTemplate().find(queryString, values);
	}

	public List<?> findByNamedParam(String queryString, String paramName,
			Object value) throws DataAccessException {

		return getHibernateTemplate().findByNamedParam(queryString, paramName,
				value);
	}

	public List<?> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) throws DataAccessException {

		return getHibernateTemplate().findByNamedParam(queryString, paramNames,
				values);
	}

	public List<?> findByValueBean(String queryString, Object valueBean)
			throws DataAccessException {

		return getHibernateTemplate().findByValueBean(queryString, valueBean);
	}

	public List<?> findByNamedQuery(String queryName, Object... values)
			throws DataAccessException {

		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) throws DataAccessException {

		return getHibernateTemplate().findByNamedParam(queryName, paramName,
				value);
	}

	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) throws DataAccessException {

		return getHibernateTemplate().findByNamedQuery(queryName, values);
	}

	public List<?> findByNamedQueryAndValueBean(String queryName,
			Object valueBean) throws DataAccessException {

		return getHibernateTemplate().findByNamedQueryAndValueBean(queryName,
				valueBean);
	}

	public List<?> findByCriteria(DetachedCriteria criteria)
			throws DataAccessException {

		return getHibernateTemplate().findByCriteria(criteria);
	}

	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) throws DataAccessException {

		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}

	public <T> List<T> findByExample(T exampleEntity)
			throws DataAccessException {

		return getHibernateTemplate().findByExample(exampleEntity);
	}

	public <T> List<T> findByExample(String entityName, T exampleEntity)
			throws DataAccessException {

		return getHibernateTemplate().findByExample(entityName, exampleEntity);
	}

	public <T> List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) throws DataAccessException {

		return getHibernateTemplate().findByExample(exampleEntity, firstResult,
				maxResults);
	}

	public <T> List<T> findByExample(String entityName, T exampleEntity,
			int firstResult, int maxResults) throws DataAccessException {

		return getHibernateTemplate().findByExample(entityName, exampleEntity,
				firstResult, maxResults);
	}

	public Iterator<?> iterate(String queryString, Object... values)
			throws DataAccessException {

		return getHibernateTemplate().iterate(queryString, values);
	}

	public void closeIterator(Iterator<?> it) throws DataAccessException {

		getHibernateTemplate().closeIterator(it);
	}

	public int bulkUpdate(String queryString, Object... values)
			throws DataAccessException {

		return getHibernateTemplate().bulkUpdate(queryString, values);
	}

}
