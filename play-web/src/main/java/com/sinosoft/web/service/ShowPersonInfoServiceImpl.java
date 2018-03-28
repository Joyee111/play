package com.sinosoft.web.service;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.ShowPersonInfoItemDao;
import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;

/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: ShowPersonInfoServiceImpl
 * @Description: TODO(实现类)
 *
 */
@Service("showPersonInfoService")
public class ShowPersonInfoServiceImpl implements ShowPersonInfoService {
	
	@Autowired
	CheckInfoService checkInfoService;
	@Autowired
	ShowPersonInfoItemDao showPersonInfoItemDao;
	@Override
	public List showPersonInfo(String username, String password) throws Exception {
		UserEntity user =  checkInfoService.checkInfo(username, password);
		
		Integer id = user.getUserId();
		StringBuilder hql = new StringBuilder("from UserInfoEntity where userInfoId = ");
		hql.append(id);
		List<UserInfoEntity> userInfo = showPersonInfoItemDao.getPersonInfo(hql.toString());
		return userInfo;
	}
	@Override
	public List<UserInfoEntity> showPersonInfo(Integer userInfoId) {
		StringBuilder hql = new StringBuilder("from UserInfoEntity where userInfoId = ");
		hql.append(userInfoId);
		List<UserInfoEntity> userInfo = showPersonInfoItemDao.getPersonInfo(hql.toString());
		return null;
	}
	public <T> T find(Criterion... criterions) throws Exception{
		return (T)showPersonInfoItemDao.find(criterions);
	}

}
