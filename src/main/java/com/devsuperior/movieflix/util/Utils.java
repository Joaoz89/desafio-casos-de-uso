package com.devsuperior.movieflix.util;

import org.springframework.data.domain.Page;

import com.devsuperior.movieflix.entities.Movie;

public class Utils {
	
	public static Page<Movie> checkIfHasNull(Page<Movie> movie){
		
		movie.map(x -> {if (x.getSubTitle() == null) {
			   x.setSubTitle("Not informed");
			}	else if(x.getImgUrl() == null) {
				x.setImgUrl("Not informed");
			} 	else if(x.getSynopsis() == null) {
				x.setSynopsis("Not informed");
			}
		return x; });
		
		return movie;	
	}
}

