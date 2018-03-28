package com.sinosoft.web.service;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.sinosoft.entity.UserInfoEntity;
/**
 * @author wangj
 * @date 2018年3月6日
 * @ClassName: ShowPersonInfoService
 * @Description: TODO(查询个人信息)
 *
 */
public interface ShowPersonInfoService {
/**
 * 根据用户账号密码查询信息
 * 
 * @param username
 * @param password
 * @return
 * @throws Exception
 */
	List showPersonInfo(String username,String password) throws Exception;
/**
 * 根据用户细单id查询 实体
 * 
 * @param userInfoId
 * @return
 */
	List<UserInfoEntity> showPersonInfo(Integer userInfoId);
	/**
	 * 根据查询条件查找对象
	 * @param <T>
	 * @param criterions
	 * @return
	 * @throws Exception
	 */
	public <T> T find(Criterion... criterions) throws Exception;
}
