package com.project.model;

import java.util.List;

public class MovieCatalogueInfo{
	
	private Integer movieId;

	private String movieName;
	
	private String movieDescription;
	
	private Integer directorId;
	
	private String movieDirector;
	
	private Integer ratingId;
	
	private String movieRating;
	
	private List<String> movieList;
	
	public MovieCatalogueInfo() {
		
	}

	
	public MovieCatalogueInfo(String movieName, String movieDescription, String movieDirector,String movieRating) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieDirector = movieDirector;
		this.movieRating = movieRating;
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


	public Integer getRatingId() {
		return ratingId;
	}


	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
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

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}


	public String getMovieRating() {
		return movieRating;
	}


	public void setMovieRating(String movieRating) {
		this.movieRating = movieRating;
	}


	public List<String> getMovieList() {
		return movieList;
	}


	public void setMovieList(List<String> movieList) {
		this.movieList = movieList;
	}


}
