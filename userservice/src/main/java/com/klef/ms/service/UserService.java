package com.klef.ms.service;

import java.util.List;

import com.klef.ms.dto.UserResquest;
import com.klef.ms.dto.LoginRequest;
import com.klef.ms.dto.OrderResponse;
import com.klef.ms.dto.ProductResponse;
import com.klef.ms.dto.UserResponse;

public interface UserService 
{

    UserResponse saveUser(UserResquest request);

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse updateUser(Long id, UserResquest request);

    void deleteUser(Long id);
    //from ProductService
    List<ProductResponse>getAllProducts();
    //from orderService
    List<OrderResponse>displayOrderbyuserId(Long userid);

    UserResponse userlogin(LoginRequest request);  //user login
    
    
}