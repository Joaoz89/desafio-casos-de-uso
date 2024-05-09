package com.devsuperior.movieflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class NewPasswordDTO {
	
	@NotBlank(message = "Requiried camp")
	private String token;
	
	@NotBlank
	@Size(min = 8, message = "Must have at last 8 caracthers")
	private String password;
	
	public NewPasswordDTO() {}

	public NewPasswordDTO( String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

}
