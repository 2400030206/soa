package com.klef.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.ms.entity.User;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
	//from User where email=?1 and password=?2
	//?1and ?2 parameter
 Optional<User> findByEmailAndPassword(String email,String Password);
  
}
