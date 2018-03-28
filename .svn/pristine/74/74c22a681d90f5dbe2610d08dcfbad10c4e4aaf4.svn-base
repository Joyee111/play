package com.sinosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "log_user_info")
/**
 * 
 * @ClassName: UserInfoEntity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author wangj
 * @date 2018年3月6日
 *
 */
public class UserInfoEntity {
	Integer id;
	Integer userInfoId;
	String name;//姓名
	Integer age;//年龄
	String address;//地址
	String educationCertification;//毕业学历
    @Id
    @GeneratedValue	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "user_info_id")
	public Integer getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "age")
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "edu_certification")
	public String getEducationCertification() {
		return educationCertification;
	}
	public void setEducationCertification(String educationCertification) {
		this.educationCertification = educationCertification;
	}
	
}
