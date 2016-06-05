package com.searchcoder.serviceImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchcoder.datamodels.Submission;
import com.searchcoder.datamodels.SubmissionDAOImpl;
import com.searchcoder.expception.SearchCoderException;
import com.searchcoder.model.ElementVO;
import com.searchcoder.model.MetaData;
import com.searchcoder.model.ModelMapper;
import com.searchcoder.model.SubmissionFilterVO;
import com.searchcoder.model.SubmissionSearchVO;
import com.searchcoder.model.SubmissionVO;
import com.searchcoder.model.SubmissionVOs;

public class SubmissionServiceImpl implements SubmissionService{

	@Autowired
	SubmissionDAOImpl submissionDAOImpl;
	
	@Autowired
	ModelMapper mapper;
	

	public SubmissionVOs fetchSubmissions() throws SearchCoderException {
		SubmissionVOs vos = new SubmissionVOs();
		List<Submission> submission = submissionDAOImpl.getSubmissions();
		List<SubmissionVO> submissionVOs = mapper.map(submission, SubmissionVO.class);
		vos.getSubmissions().addAll(submissionVOs);

		return vos;
	}
	
	public SubmissionVOs filterSubmissions(SubmissionSearchVO searchVO) throws SearchCoderException {
		SubmissionVOs filterSubmission = new SubmissionVOs();
		if(StringUtils.isBlank(searchVO.getName()) || StringUtils.isBlank(searchVO.getValue())){
			return filterSubmission;
		}
		
		List<Submission>submissionDAO =  submissionDAOImpl.filterSubmissions(searchVO);
		List<SubmissionVO>submissionVOs = mapper.map(submissionDAO, SubmissionVO.class);
		filterSubmission = new SubmissionVOs();
		filterSubmission.getSubmissions().addAll(submissionVOs);
		 
		return filterSubmission;
	}
	
	public SubmissionFilterVO SearchSubmissions(int pageNumber, int pageSize) throws SearchCoderException {
		SubmissionSearchVO searchVO = new SubmissionSearchVO();
		searchVO.setPageNumber(pageNumber);
		searchVO.setPageSize(pageSize);
		List<Submission>submission =  submissionDAOImpl.filterSubmissions(searchVO);
		SubmissionFilterVO filter = new SubmissionFilterVO();
		filter.setCount(submission.size());
		//Top five language
		List<ElementVO> els = new ArrayList<ElementVO>();
		int count =5;
		List<Entry<String, Integer>> lang = topLanguage(submission);
		for(Entry<String, Integer> en  : lang){
			if(count == 0) break;
			ElementVO el = new ElementVO();
			el.setName(en.getKey());
			el.setValue(en.getValue().toString());
			count --;
			els.add(el);
		}
		filter.getLanguageUsed().addAll(els);
		//Top 2 submission attempted
		els = new ArrayList<ElementVO>();
		count =2;
		List<Entry<String, Integer>>  attempt = topSubmissionAttempted(submission);
		for(Entry<String, Integer> m : attempt){
			if(count == 0)break;
			ElementVO el = new ElementVO();
			el.setName(m.getKey());
			el.setValue(m.getValue().toString());
			count --;
			els.add(el);
		}
		filter.getSubmissionsAttempted().addAll(els);
		//Submission per level
		els = new ArrayList<ElementVO>();
		List<Entry<String, Integer>> topSub = topSubmissionByLevel(submission);
		for(Entry<String, Integer> m : topSub){
			ElementVO el = new ElementVO();
			el.setName(m.getKey());
			el.setValue(m.getValue().toString());
			els.add(el);
		}
		filter.getSubmissionPerLevel().addAll(els);
		//Total Submission
		Integer total = totalSubmissions(submission);
		filter.setTotalSubmitions(total.toString());
		
		return filter;
	}
	
	private List<Entry<String, Integer>> topLanguage(List<Submission>submission){
		Map<String, Integer> langCount  = new HashMap<String, Integer>();
		for (Submission sub : submission) {
			int tmp=0;
			if (langCount.containsKey(sub.getLanguage())) {
				int count = langCount.get(sub.getLanguage());
				langCount.put(sub.getLanguage(), ++count);
				continue;
			}
			langCount.put(sub.getLanguage(), ++tmp);
		}
		
		return sortMap(langCount);
	}
	
	private List<Entry<String, Integer>>  topSubmissionAttempted(List<Submission>submission) throws SearchCoderException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> level = new HashMap<String, Integer>();
		int max = 0;
		for(Submission sub : submission){
			MetaData data;
			try {
				data = mapper.readValue(sub.getMetadata(), MetaData.class);
			} catch (IOException e) {
				throw new SearchCoderException(e);
			}
			if(data.getAttempted() > max){
				max=data.getAttempted();
				level.put(sub.getTitle(),max);
			}
		}
		
		return sortMap(level);
	}

	private List<Entry<String, Integer>> topSubmissionByLevel(List<Submission>submission) throws SearchCoderException{
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> level = new HashMap<String, Integer>();
		for(Submission sub : submission){
			MetaData data;
			try {
				data = mapper.readValue(sub.getMetadata(), MetaData.class);
			} catch (IOException e) {
				throw new SearchCoderException(e);
			}
			
			if("Accepted".equals(sub.getStatus())){
				int tmp=0;
				if (level.containsKey(data.getLevel())) {
					int count = level.get(data.getLevel());
					level.put(data.getLevel(), ++count);
					continue;
				}
				level.put(data.getLevel(), ++tmp);
			}
		}
		
		return sortMap(level);
	}

	private int totalSubmissions(List<Submission>submission) throws SearchCoderException{
		int count =0;
		for(Submission sub : submission){
			if("Accepted".equals(sub.getStatus())){
				count++;
			}
		}

		return count;
	}
	
	private List<Entry<String, Integer>> sortMap(Map<String, Integer> level) {
		List<Entry<String, Integer>> list =  new LinkedList<Entry<String, Integer>>(level.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		} );
		
		return list;
	}
	public void setSubmissionDAOImpl(SubmissionDAOImpl submissionDAOImpl) {
		this.submissionDAOImpl = submissionDAOImpl;
	}

	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}


}
