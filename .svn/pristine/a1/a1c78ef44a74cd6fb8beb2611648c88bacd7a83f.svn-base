package com.sinosoft.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.PersonRepository;
import com.sinosoft.entity.UserEntity;




/**
 * 
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: CheckInfoServiceImpl
 * @Description: TODO(实现类)
 *
 * @param <T>
 */
@Service
public class CheckInfoServiceImpl<T> implements CheckInfoService {
	
	@Autowired
	private PersonRepository personRepository;
	@Override
	public UserEntity checkInfo(String username,String password) throws Exception {
		String sql = "from UserEntity where username = '"+ username+"' and password = '"+password+"'";
		List user =  personRepository.getPersonInfo(sql);
		UserEntity userentity = (UserEntity)user.get(0);
		return userentity;
	}
}
