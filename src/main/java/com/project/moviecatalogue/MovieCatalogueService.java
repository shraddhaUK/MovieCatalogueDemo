package com.project.moviecatalogue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.MovieCatalogueInfo;

import ch.qos.logback.classic.spi.STEUtil;

@RestController
public class MovieCatalogueService {
	private MovieCatalogueRepository movieCatalogueRepository;
	private DirectorRepository directorRepository;
	private MovieRatingRepository ratingRepository;
	private MovieDirectorRepository moviedirectorRepository;
	private MovieCatalogueInfo movieInfo;
	
	public MovieCatalogueService(MovieCatalogueRepository repo,DirectorRepository directorRepository,MovieRatingRepository ratingRepository,MovieDirectorRepository moviedirectorRepository) {
		super();
		this.movieCatalogueRepository = repo;
		this.directorRepository = directorRepository;
		this.ratingRepository =ratingRepository;
		this.moviedirectorRepository =moviedirectorRepository;
	}

	@GetMapping("/movies")
	public List<MovieCatalogueInfo> getMovieCatalogueList(){
		
		Iterable<MovieEntity> ime =movieCatalogueRepository.findAll();
		List<MovieCatalogueInfo> list = new ArrayList<MovieCatalogueInfo>();
		
		for(MovieEntity me : ime) {
			movieInfo =new MovieCatalogueInfo();
			movieInfo.setMovieId(me.getMovieId());
			movieInfo.setMovieName(me.getMovieName());
			movieInfo.setMovieDescription(me.getMovieDescription());
			movieInfo.setDirectorId(me.getDirectorId());
			movieInfo.setRatingId(me.getRatingId());
			movieInfo.setMovieDirector(directorRepository.findById(me.getDirectorId()).get().getName());
			movieInfo.setMovieRating(ratingRepository.findById(me.getRatingId()).get().getRating());
			list.add(movieInfo);
		}
		
		return list;
	}

	
	@PostMapping("/movies")
	public void insertMovie(@RequestBody MovieCatalogueInfo movieInfo){
		
		MovieEntity me = new MovieEntity();
		me.setMovieName(movieInfo.getMovieName());
		me.setMovieDescription(movieInfo.getMovieDescription());
		me.setDirectorId(movieInfo.getDirectorId());
		me.setRatingId(movieInfo.getRatingId());
		movieCatalogueRepository.save(me);
	}
	
	@PatchMapping("/movies/{movieId}")
	public void updateMovie(@PathVariable Integer movieId,@RequestBody MovieCatalogueInfo movieInfo){
		
		Optional<MovieEntity> op = movieCatalogueRepository.findById(movieId);
		MovieEntity movie =op.get();
		movie.setMovieDescription(movieInfo.getMovieDescription());
		movieCatalogueRepository.save(movie);
		
	}
	
	@DeleteMapping("/movies/{movieId}")
	public void deleteMovie(@PathVariable Integer movieId){
		Optional<MovieEntity> op = movieCatalogueRepository.findById(movieId);
		MovieEntity movie =op.get();
		movieCatalogueRepository.delete(movie);
	}
	
	@PostMapping("/directors")
	public void insertDirector(@RequestBody MovieCatalogueInfo movieInfo){
		
		DirectorEntity de = new DirectorEntity();
		de.setName(movieInfo.getMovieDirector());
		directorRepository.save(de);
	}
	
	@PatchMapping("/directors/{directorId}")
	public void updateDirector(@PathVariable Integer directorId,@RequestBody MovieCatalogueInfo movieInfo){
		
		Optional<DirectorEntity> op = directorRepository.findById(directorId);
		DirectorEntity director =op.get();
		
		director.setName(movieInfo.getMovieDirector());
		
		directorRepository.save(director);
		
	}
	
	@DeleteMapping("/directors/{directorId}")
	public void deleteDirector(@PathVariable Integer directorId){
		
		Optional<DirectorEntity> op = directorRepository.findById(directorId);
		DirectorEntity director =op.get();
		
		directorRepository.delete(director);
	}
	
	
	
	@PostMapping("/ratings")
	public void insertRatings(@RequestBody MovieCatalogueInfo movieInfo){
		RatingsEntity re = new RatingsEntity();
		re.setRating(movieInfo.getMovieRating());
		ratingRepository.save(re);
	}
	
	@PatchMapping("/ratings/{ratingId}")
	public void updateRatings(@PathVariable Integer ratingId,@RequestBody MovieCatalogueInfo movieInfo){
		
		Optional<RatingsEntity> op = ratingRepository.findById(ratingId);
		RatingsEntity rating =op.get();
		
		rating.setRating(movieInfo.getMovieRating());
		
		ratingRepository.save(rating);
		
	}
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRatings(@PathVariable Integer ratingId){
		
		Optional<RatingsEntity> op = ratingRepository.findById(ratingId);
		RatingsEntity rating =op.get();
		
		ratingRepository.delete(rating);
	}

	
	@GetMapping("/movies/{directorId}")
	public List<String> searchMoviesByDirector(@PathVariable Integer directorId){
		
		Iterable<MovieEntity> movieList = 	movieCatalogueRepository.findAll();
		
		List<String> movieNamesList = new ArrayList<String>();
		for(MovieEntity me : movieList) {
			if(me.getDirectorId().equals(directorId))
			movieNamesList.add(me.getMovieName());
			else
				continue;
		}
		 movieInfo =new MovieCatalogueInfo();
		movieInfo.setMovieList(movieNamesList);
		return movieInfo.getMovieList();
		
	}
	
	@GetMapping("/moviesByRating")
	public List<String> searchMoviesByRatingId(@RequestParam(value = "rating" , defaultValue = "1") Integer rating){
		
		Iterable<RatingsEntity> op =ratingRepository.findAll();
		
		Spliterator<RatingsEntity> sps=op.spliterator();
		
		Stream<RatingsEntity> s =StreamSupport.stream(sps, false);
		
		List<Integer> ratingIdsList=s.filter(r->Integer.parseInt(r.getRating())>rating)
		.map(RatingsEntity :: getId)
		.collect(Collectors.toList());
		
		Iterable<Integer> i = ratingIdsList;
		List<String> movieNamesList = new ArrayList<String>();
		for(Integer j :i) {
			Iterable<MovieEntity> movieList = 	movieCatalogueRepository.findAll();
			for(MovieEntity m :movieList) {
				if(m.getRatingId().equals(j)) {
					movieNamesList.add(m.getMovieName());
				}
			}
			
		}
		 movieInfo =new MovieCatalogueInfo();
		movieInfo.setMovieList(movieNamesList);
		return movieInfo.getMovieList();
	}
}
