package com.sinosoft.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.core.dao.PersonRepository;
import com.sinosoft.entity.UserEntity;

/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: GetEntityByIdImpl
 * @Description: TODO(实现类/已废除)
 *
 * @param <T>
 */
@Service("getEntityById")
public class GetEntityByIdImpl<T> implements GetEntityById {

	@Autowired
	private PersonRepository personRepository;
		@Override
		public UserEntity getEntityById(Integer id) {
			Long userId = (long)id;
			UserEntity user = personRepository.get(userId);
			return user;
		}
}
