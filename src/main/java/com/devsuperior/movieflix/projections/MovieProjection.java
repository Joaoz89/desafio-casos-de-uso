package com.devsuperior.movieflix.projections;

public interface MovieProjection {
	
	Long getGenre_Id();
	String getName();
	
	String getTitle();
	String getSynopsis();
	String getImg_url();
	Integer getMovie_Year();
	String getSub_Title();
	Long getId();  

}
