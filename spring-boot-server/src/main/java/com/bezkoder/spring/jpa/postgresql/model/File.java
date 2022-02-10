package com.bezkoder.spring.jpa.postgresql.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "File")
public class File {

	@Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;

	  private String name;

	  private String type;
	  
	  private String url;

	  private int departmentId;
	  
	  @Lob
	  private byte[] data;

	  public File() {
	  }

	  public File(String name, String type, byte[] data,int departmentId) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	    this.departmentId = departmentId;
	  }

	  public String getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public byte[] getData() {
	    return data;
	  }

	  public void setData(byte[] data) {
	    this.data = data;
	  }
	  
	  

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", departmentId="
				+ departmentId + ", data=" + Arrays.toString(data) + "]";
	}

	
	  
	  
	  
	  

}
