package com.searchcoder.datamodels;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;


public interface SearchCoderDaoTempate{

	public <T> T execute(HibernateCallback<T> action)
			throws DataAccessException;

	public <T> T get(Class<T> entityClass, Serializable id)
			throws DataAccessException;

	public <T> T get(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException;

	public Object get(String entityName, Serializable id)
			throws DataAccessException;

	public Object get(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException;

	public <T> T load(Class<T> entityClass, Serializable id)
			throws DataAccessException;

	public <T> T load(Class<T> entityClass, Serializable id, LockMode lockMode)
			throws DataAccessException;

	public Object load(String entityName, Serializable id)
			throws DataAccessException;

	public Object load(String entityName, Serializable id, LockMode lockMode)
			throws DataAccessException;

	public <T> List<T> loadAll(Class<T> entityClass) throws DataAccessException;

	public void load(Object entity, Serializable id) throws DataAccessException;

	public void refresh(Object entity) throws DataAccessException;

	public void refresh(Object entity, LockMode lockMode)
			throws DataAccessException;

	public boolean contains(Object entity) throws DataAccessException;

	public void evict(Object entity) throws DataAccessException;

	public void initialize(Object proxy) throws DataAccessException;

	public Filter enableFilter(String filterName) throws IllegalStateException;

	public void lock(Object entity, LockMode lockMode)
			throws DataAccessException;

	public void lock(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException;

	public Serializable save(Object entity) throws DataAccessException;

	public Serializable save(String entityName, Object entity)
			throws DataAccessException;

	public void update(Object entity) throws DataAccessException;

	public void update(Object entity, LockMode lockMode)
			throws DataAccessException;

	public void update(String entityName, Object entity)
			throws DataAccessException;

	public void update(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException;

	public void saveOrUpdate(Object entity) throws DataAccessException;

	public void saveOrUpdate(String entityName, Object entity)
			throws DataAccessException;

	public void replicate(Object entity, ReplicationMode replicationMode)
			throws DataAccessException;

	public void replicate(String entityName, Object entity,
			ReplicationMode replicationMode) throws DataAccessException;

	public void persist(Object entity) throws DataAccessException;

	public void persist(String entityName, Object entity)
			throws DataAccessException;

	public <T> T merge(T entity) throws DataAccessException;

	public <T> T merge(String entityName, T entity) throws DataAccessException;

	public void delete(Object entity) throws DataAccessException;

	public void delete(Object entity, LockMode lockMode)
			throws DataAccessException;

	public void delete(String entityName, Object entity)
			throws DataAccessException;

	public void delete(String entityName, Object entity, LockMode lockMode)
			throws DataAccessException;

	public void deleteAll(Collection<?> entities) throws DataAccessException;

	public void flush() throws DataAccessException;

	public void clear() throws DataAccessException;

	public List<?> find(String queryString, Object... values)
			throws DataAccessException;

	public List<?> findByNamedParam(String queryString, String paramName,
			Object value) throws DataAccessException;

	public List<?> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) throws DataAccessException;

	public List<?> findByValueBean(String queryString, Object valueBean)
			throws DataAccessException;

	public List<?> findByNamedQuery(String queryName, Object... values)
			throws DataAccessException;

	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) throws DataAccessException;

	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) throws DataAccessException;

	public List<?> findByNamedQueryAndValueBean(String queryName,
			Object valueBean) throws DataAccessException;

	public List<?> findByCriteria(DetachedCriteria criteria)
			throws DataAccessException;

	public List<?> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) throws DataAccessException;

	public <T> List<T> findByExample(T exampleEntity)
			throws DataAccessException;

	public <T> List<T> findByExample(String entityName, T exampleEntity)
			throws DataAccessException;

	public <T> List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) throws DataAccessException;

	public <T> List<T> findByExample(String entityName, T exampleEntity,
			int firstResult, int maxResults) throws DataAccessException;

	public Iterator<?> iterate(String queryString, Object... values)
			throws DataAccessException;

	public void closeIterator(Iterator<?> it) throws DataAccessException;

	public int bulkUpdate(String queryString, Object... values)
			throws DataAccessException;

}
