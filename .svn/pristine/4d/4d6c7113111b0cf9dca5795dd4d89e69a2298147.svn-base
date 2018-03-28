package com.sinosoft.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="log_resource")
public class ResourceEntity {
 Integer id;
 String resourceName;
 String resourceCode;
 String resourceUrl;
@Id
 @GeneratedValue
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Column(name = "resource_url")
public String getResourceUrl() {
	return resourceUrl;
}
public void setResourceUrl(String resourceUrl) {
	this.resourceUrl = resourceUrl;
}
@Column(name="resource_name")
public String getResourceName() {
	return resourceName;
}
public void setResourceName(String resourceName) {
	this.resourceName = resourceName;
}
@Column(name="resource_code")
public String getResourceCode() {
	return resourceCode;
}
public void setResourceCode(String resourceCode) {
	this.resourceCode = resourceCode;
}
 
}
