package com.klef.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.ms.entity.User;
@Repository
public interface UserRespository extends JpaRepository<User, Long> {

}
