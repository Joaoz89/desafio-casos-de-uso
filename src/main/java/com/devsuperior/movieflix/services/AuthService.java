package com.devsuperior.movieflix.services;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.EmailDTO;
import com.devsuperior.movieflix.dto.NewPasswordDTO;
import com.devsuperior.movieflix.entities.PasswordRecover;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.PasswordRecoveryRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class AuthService {
	
	@Value("${email.password-recover.token.minutes}")
	private Long tokenMinutes;
	
	@Value("${email.password-recover.uri}")
	private String recoverURI;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordRecoveryRepository passwordRecoveryRepository; 
	
	@Autowired
    private EmailService emailService;
	
	@Transactional
	public void createRecoveryToken(EmailDTO body) {

		User user = userRepository.findByEmail(body.getEmail());
		if(user == null) throw new ResourceNotFoundException("Email not found");
		String token = UUID.randomUUID().toString();

		PasswordRecover entity = new PasswordRecover();
		entity.setEmail(body.getEmail());
		entity.setToken(token);
		entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60L));
		entity = passwordRecoveryRepository.save(entity);
		String text = "Acesse o link para definir uma nova senha (válido por " + tokenMinutes + " minutos):\n\n"
				+ recoverURI + token;		
        emailService.sendEmail(body.getEmail(), "Password recovery", text);
	}
	@Transactional
	public void saveNewPassword( NewPasswordDTO dto) {

		List<PasswordRecover> result = passwordRecoveryRepository.searchValidTokens(dto.getToken(), Instant.now());
		if(result.size() == 0) throw new ResourceNotFoundException("Invalid token");
		User user = userRepository.findByEmail(result.get(0).getEmail());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user = userRepository.save(user);
	}
	

protected User authenticated() {
  try {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
    String username = jwtPrincipal.getClaim("username"); //email
    return userRepository.findByEmail(username);
  }
  catch (Exception e) {
    throw new UsernameNotFoundException("Invalid user");
  }
}

}
