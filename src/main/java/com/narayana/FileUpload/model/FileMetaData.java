package com.narayana.FileUpload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileMetaData {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String filename;
	private String size;
	private String creationtime;
	private String lastaccesstime;
	private String lastmodifiedtime;
	private String isregularfile;
	private String isother;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(String creationtime) {
		this.creationtime = creationtime;
	}
	public String getLastaccesstime() {
		return lastaccesstime;
	}
	public void setLastaccesstime(String lastaccesstime) {
		this.lastaccesstime = lastaccesstime;
	}
	public String getLastmodifiedtime() {
		return lastmodifiedtime;
	}
	public void setLastmodifiedtime(String lastmodifiedtime) {
		this.lastmodifiedtime = lastmodifiedtime;
	}
	public String getIsregularfile() {
		return isregularfile;
	}
	public void setIsregularfile(String isregularfile) {
		this.isregularfile = isregularfile;
	}
	public String getIsother() {
		return isother;
	}
	public void setIsother(String isother) {
		this.isother = isother;
	}	
	
	

}
