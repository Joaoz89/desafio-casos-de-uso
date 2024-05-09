package com.devsuperior.movieflix.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.PasswordRecover;


public interface PasswordRecoveryRepository extends JpaRepository<PasswordRecover, Long>{

	@Query("SELECT obj FROM PasswordRecover obj WHERE obj.token = :token AND obj.expiration > :now")
	List<PasswordRecover> searchValidTokens(String token, Instant now);
}
