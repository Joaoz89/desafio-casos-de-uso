package com.devsuperior.movieflix.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserInsertDTO extends UserDTO {
	
	
	@NotBlank(message = "Campo requerido")
	@Size(min = 8, message = "Deve ter no mínimo 8 caracteres")
	private String password;
	
	public UserInsertDTO() {
		 	super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
