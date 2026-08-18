package com.klef.ms.service;

import java.util.List;

import com.klef.ms.dto.UserResquest;
import com.klef.ms.dto.UserResponse;

public interface UserService 
{

    UserResponse saveUser(UserResquest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, UserResquest request);

    void deleteUser(Long id);

}