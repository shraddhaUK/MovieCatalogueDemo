package com.project.moviecatalogue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.project.model.MovieCatalogueInfo;

class MovieCatalogueServiceTest {

	 @Test
     public void checkSearch() {
         MovieCatalogueService mcs = new MovieCatalogueService(null, null, null, null);
         List<MovieCatalogueInfo> list =new ArrayList<MovieCatalogueInfo>();
         List<String> movieNamesList = new ArrayList<String>();
         assertEquals(list, mcs.getMovieCatalogueList());
         assertEquals(movieNamesList, mcs.searchMoviesByDirector(1));

     }

     @Test
     public void checkSinglesNoSingles() {
    	 MovieCatalogueService mcs = new MovieCatalogueService(null, null, null, null);
         assertEquals(null, mcs.getMovieCatalogueList());
     }

}
