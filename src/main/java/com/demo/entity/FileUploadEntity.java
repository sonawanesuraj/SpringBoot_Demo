package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "file_entity")
public class FileUploadEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "filename")
	private String filename;

	@Column(name = "file_type")
	private String type;

	@Column(name = "mimetype")
	private String mimetype;

	@Column(name = "encoding")
	private String encoding;

	@Column(name = "size")
	private Long size;

	@Column(name = "original_name ")
	private String originalName;

	@Column(name = "is_active")
	private boolean isActive = true;

	@Column(name = "createdAt")
	@CreationTimestamp
	private Date createdAt;

	public FileUploadEntity(int id, String filename, String type, String mimetype, String encoding, Long size,
			String originalName, boolean isActive, Date createdAt) {
		super();
		this.id = id;
		this.filename = filename;
		this.type = type;
		this.mimetype = mimetype;
		this.encoding = encoding;
		this.size = size;
		this.originalName = originalName;
		this.isActive = isActive;
		this.createdAt = createdAt;
	}

	public FileUploadEntity() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
