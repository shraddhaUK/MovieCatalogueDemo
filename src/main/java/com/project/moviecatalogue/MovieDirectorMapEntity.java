package com.project.moviecatalogue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieDirectorMap")
public class MovieDirectorMapEntity {

	public MovieDirectorMapEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer movieId;
	
	private Integer directorId;
	
	public MovieDirectorMapEntity(Integer id,Integer movieId, Integer directorId) {
		super();
		this.id = id ;
		this.movieId = movieId;
		this.directorId = directorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

}
