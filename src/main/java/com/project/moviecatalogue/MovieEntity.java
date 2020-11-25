package com.project.moviecatalogue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity  {
	
	public MovieEntity() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name = "movieId")
	private Integer movieId;
	
	//@Column(name = "movieName")
	private String movieName;
	
	//@Column(name = "movieDescription")
	private String movieDescription;
	
	private Integer directorId;
	
	private Integer ratingId;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "directorId") private DirectorEntity director;
	 */
	
	
	
	public MovieEntity(Integer movieId, String movieName, String movieDescription, Integer directorId, Integer ratingId) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.directorId = directorId;
		this.ratingId = ratingId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public Integer getDirectorId() {
		return directorId;
	}

	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

//	public DirectorEntity getDirector() {
//		return director;
//	}
//
//	public void setDirector(DirectorEntity director) {
//		this.director = director;
//	}

}
