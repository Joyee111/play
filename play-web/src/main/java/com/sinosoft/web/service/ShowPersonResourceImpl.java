package com.sinosoft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.ShowPersonInfoItemDao;
import com.sinosoft.entity.ResourceEntity;
@Service("showPersonResource")
public class ShowPersonResourceImpl implements ShowPersonResourceService {
	
	@Autowired
	ShowPersonInfoItemDao showPersonInfoItemDao;
	
	@Override
	public List<ResourceEntity> findByHql(String hql, Map<String, Object> map) throws Exception {
		return showPersonInfoItemDao.findByHql(hql, map);
	}
	

}
