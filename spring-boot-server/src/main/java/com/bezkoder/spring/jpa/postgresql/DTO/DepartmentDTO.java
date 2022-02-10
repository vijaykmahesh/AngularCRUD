package com.bezkoder.spring.jpa.postgresql.DTO;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "departmentId", "departmentName", "createdUserId", "createdDate", "lastModifiedUserId",
		"lastModifiedDate" })
public class DepartmentDTO {
	@JsonProperty("departmentId")
	private long departmentId;

	@JsonProperty("departmentName")
	private String departmentName;

	@JsonProperty("createdUserId")
	private long createdUserId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("createdDate")
	private Date createdDate;

	@JsonProperty("lastModifiedUserId")
	private long lastModifiedUserId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("lastModifiedDate")
	private Date lastModifiedDate;

	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getCreatedUserId() {
		return createdUserId;
	}

	public void setCreatedUserId(long createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getLastModifiedUserId() {
		return lastModifiedUserId;
	}

	public void setLastModifiedUserId(long lastModifiedUserId) {
		this.lastModifiedUserId = lastModifiedUserId;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}