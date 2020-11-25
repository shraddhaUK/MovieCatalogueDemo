package com.project.moviecatalogue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class RatingsEntity {

	public RatingsEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String rating;
	
	public RatingsEntity(Integer id,Integer movieid, String rating) {
		super();
		this.id = id ;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}



}
