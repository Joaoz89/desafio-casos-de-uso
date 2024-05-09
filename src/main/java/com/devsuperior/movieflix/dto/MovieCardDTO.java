package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;

public class MovieCardDTO {

    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    
    private GenreDTO genre;
    
    public MovieCardDTO() {
    }
    
	public MovieCardDTO(Movie entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.subTitle = entity.getSubTitle();
    	this.year = entity.getYear();
    	this.imgUrl = entity.getImgUrl();
    	
    	this.genre = new GenreDTO(entity.getGenre());
    	
    }
	public MovieCardDTO(Movie entity, Genre genre) {
		this(entity);
		this.genre = new GenreDTO(genre);
	}
	 
    public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
