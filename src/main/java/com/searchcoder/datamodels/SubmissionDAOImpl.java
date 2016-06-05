package com.searchcoder.datamodels;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import com.searchcoder.model.SubmissionSearchVO;

public class SubmissionDAOImpl extends SearchCoderGenericDAO{
	
	
	@Transactional
	public List<Submission> getSubmissions() {
		List<Submission> submissions = getHibernateTemplate().execute(new HibernateCallback<List<Submission>>() {
			@SuppressWarnings("unchecked")
			public List<Submission> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Submission s ");
				return query.list();
			}
		});

		return submissions;
	}

	@Transactional
	public Submission getSubmissionById(final String title) {
		Submission submission = getHibernateTemplate().execute(new HibernateCallback<Submission>() {
			public Submission doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Submission s where s.title = :title");
				query.setParameter("title", title);
				return (Submission) query.uniqueResult();
			}
		});

		return submission;
	}
	
	@Transactional
	public List<Language> getLanguage() {
		List<Language> language = getHibernateTemplate().execute(new HibernateCallback<List<Language>>() {
			@SuppressWarnings("unchecked")
			public List<Language> doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Language l");

				return (List<Language>) query.uniqueResult();
			}
		});

		return language;
	}
	
	@Transactional
	public List<Submission> filterSubmissions(final SubmissionSearchVO searchVO) {
		List<Submission> submission = getHibernateTemplate().execute(new HibernateCallback<List<Submission>>() {
			@SuppressWarnings("unchecked")
			public List<Submission> doInHibernate(Session session) throws HibernateException {

				Criteria submissionCriteria = session.createCriteria(Submission.class);
				if(StringUtils.isNotBlank(searchVO.getName())){
					submissionCriteria.add(Restrictions.like(searchVO.getName(), searchVO.getValue()));
				}
				
				submissionCriteria.setFirstResult(searchVO.getPageNumber());
				submissionCriteria.setMaxResults(searchVO.getPageSize());
				
				return (List<Submission>) submissionCriteria.list();
			}
		});

		return submission;
	}
}
