package com.sinosoft.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;

import com.sinosoft.entity.UserEntity;
import com.sinosoft.entity.UserInfoEntity;
/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: DomainRepository
 * @Description: TODO(dao层父接口)

 *
 * @param <T>
 * @param <Integer>
 */
public interface DomainRepository<T,Integer extends Serializable>{

    /**
     * 根据sql获取用户信息
     * 
     * @author wangj
     */
    List getPersonInfo(String sql);
/**
 * 返回用户实体
 */
	UserEntity get(Long id);
/**
 * 删除用户信息
 */
	void delete(Long id);
	/**
	 * 保存用户细单信息
	 */
	void save(UserInfoEntity user);
	/**
	 * 根据查询条件查找对象
	 * @param criterions
	 * @return
	 * @throws Exception
	 */
	public T find(Criterion... criterions) throws Exception;


	
}
