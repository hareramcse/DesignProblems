package com.sapient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "amneti")
public class Amneti {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "amnetiId")
	private Long amnetiId;

	@Column(name = "amnetiName")
	private String amnetiName;

	public Long getAmnetiId() {
		return amnetiId;
	}

	public void setAmnetiId(Long amnetiId) {
		this.amnetiId = amnetiId;
	}

	public String getAmnetiName() {
		return amnetiName;
	}

	public void setAmnetiName(String amnetiName) {
		this.amnetiName = amnetiName;
	}
}
