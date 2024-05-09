package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.projections.MovieProjection;

public class MovieDTO {

	private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    
    private Genre genre;
    
    public MovieDTO() {
    }
    
	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, Genre genre) {
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.genre = genre;
	}
	
	public MovieDTO(MovieProjection pro) {
	 id = pro.getId();
	 title = pro.getTitle();
	 subTitle = pro.getSub_Title();
	 year = pro.getMovie_Year();
	 imgUrl = pro.getImg_url();
	 
	 genre = new Genre(null, pro.getName());
		
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
}
