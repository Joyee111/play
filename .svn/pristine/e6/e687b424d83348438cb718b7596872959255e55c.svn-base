package com.sinosoft.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.ShowPersonInfoItemDao;
import com.sinosoft.entity.UserRoleEntity;
@Service("showPersonRoleSerivce")
public class ShowPersonRoleServiceImpl implements ShowPersonRoleService {
	
	@Autowired
	ShowPersonInfoItemDao showPersonInfoItemDao;
	
	@Override
	public List<UserRoleEntity> findByHql(String hql, Map<String, Object> args) throws Exception {
		showPersonInfoItemDao.findByHql(hql, args);
		return null;
	}

}
