package com.project.moviecatalogue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "directors")
public class DirectorEntity {

	public DirectorEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "directorId")
	private Integer directorId;
	
	//@Column(name = "directorName")
	private String directorName;
	
	public DirectorEntity(Integer id, String name) {
		super();
		this.directorId = id;
		this.directorName = name;
	}

	public Integer getId() {
		return directorId;
	}

	public void setId(Integer id) {
		this.directorId = id;
	}

	public String getName() {
		return directorName;
	}

	public void setName(String name) {
		this.directorName = name;
	}

}
