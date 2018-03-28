package com.sinosoft.core.dao;


import java.util.List;
import java.util.Map;

import com.sinosoft.core.dao.PersonRepository;
/**
 * 
 * @ClassName: ShowPersonInfoItemDao
 * @Description: TODO()
 * @author wangj
 * @date 2018年3月6日
 *
 */
public interface ShowPersonInfoItemDao extends DomainRepository {

	public <T> List<T> findByHql(String hql, Map<String, Object> args) throws Exception;
	
	
}
