package com.devsuperior.movieflix.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class EmailDTO {

    @NotBlank(message = "Fill")
    @Email(message = "Invalid email")
    private String email;
    
    public EmailDTO() {};
    
	public EmailDTO(String email) {
	
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
