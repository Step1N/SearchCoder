package com.searchcoder.model;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ModelMapper {
	
	@Autowired
	DozerBeanMapper customemapper;
	
	public void map(Object source, Class<Object> destType){
		customemapper.map(source, destType);
	}
	
	public <T, U> ArrayList<U> map(final List<T> source, final Class<U> destType) {
		final ArrayList<U> dest = new ArrayList<U>();
		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(customemapper.map(element, destType));
		}
		
		List<T> s1 = new ArrayList<T>();
		s1.add(null);
		dest.removeAll(s1);

		return dest;
	}

	public void setCustomemapper(DozerBeanMapper customemapper) {
		this.customemapper = customemapper;
	}
}
	
