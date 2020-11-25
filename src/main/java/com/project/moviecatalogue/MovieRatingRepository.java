package com.project.moviecatalogue;

import org.springframework.data.repository.CrudRepository;

public interface MovieRatingRepository extends CrudRepository<RatingsEntity, Integer> {

}
