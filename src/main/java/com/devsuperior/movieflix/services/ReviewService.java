package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;

	@Autowired
	private AuthService authService;
	
	@Autowired
	private MovieRepository moRepo;

	@Transactional
	public ReviewDTO insert( ReviewDTO dto) {
		Review entity = new Review();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}

	private void copyDtoToEntity(ReviewDTO dto, Review entity) {

		entity.setId(dto.getId());
		entity.setText(dto.getText());
		Movie movie = moRepo.getReferenceById(dto.getMovieId());
		//entity.setMovie(movie);
		entity.setMovie(new Movie(dto.getMovieId(), null, null, null, null, null));

		User user = authService.authenticated();
		entity.setUser(user);		
	}
}
