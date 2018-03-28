package com.sinosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "role_dependency_resource")
public class RoleDependencyResouceEntity {
 Integer id;
 Integer roleId;
 Integer resourceId;
 @Id
 @GeneratedValue
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name = "role_id")
public Integer getRoleId() {
	return roleId;
}
public void setRoleId(Integer roleId) {
	this.roleId = roleId;
}
@Column(name = "resource_id")
public Integer getResourceId() {
	return resourceId;
}
public void setResourceId(Integer resourceId) {
	this.resourceId = resourceId;
}
 
 
}
