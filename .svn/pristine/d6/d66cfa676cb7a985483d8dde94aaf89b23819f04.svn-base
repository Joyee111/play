package com.sinosoft.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.PersonRepository;
import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;
/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: SaveInfoServiceImpl
 * @Description: TODO(实现类)

 *
 */
@Service("saveInfoSerivce")
public class SaveInfoServiceImpl implements SaveInfoService {
	@Autowired
	private PersonRepository personRepository;
	@Override
	public String save(UserInfoEntity user) {
		try{
		personRepository.save(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	@Override
	public void save(UserEntity user) {
		personRepository.save(user);
		
	}

}
