package com.klef.ms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.klef.ms.client.ProductClient;
import com.klef.ms.client.UserClient;
import com.klef.ms.dto.OrderRequest;
import com.klef.ms.dto.OrderResponse;
import com.klef.ms.dto.ProductResponse;
import com.klef.ms.dto.UserResponse;
import com.klef.ms.entity.Order;
import com.klef.ms.expectation.ResourceNotFoundException;
import com.klef.ms.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final UserClient userClient;
    private final ProductClient productClient;

    @Override
    public OrderResponse saveOrder(OrderRequest request) {

        // Call User Service using OpenFeign
        UserResponse user =
                userClient.getUserById(request.getUserId());

        // Call Product Service using OpenFeign
        ProductResponse product =
                productClient.getProductById(request.getProductId());

        // Calculate total amount
        double totalAmount =
                product.getPrice() * request.getQuantity();

        // Create Order
        Order order = Order.builder()
                .userId(user.getId())
                .productId(product.getId())
                .quantity(request.getQuantity())
                .totalAmount(totalAmount)
                .build();

        // Save Order
        Order savedOrder = repository.save(order);

        return mapToResponse(savedOrder);
    }

    @Override
    public List<OrderResponse> getAllOrders() {

        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse getOrderById(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id : " + id));

        return mapToResponse(order);
    }

    @Override
    public OrderResponse updateOrder(Long id, OrderRequest request) {

        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id : " + id));

        // Verify user exists
        UserResponse user =
                userClient.getUserById(request.getUserId());

        // Get product details
        ProductResponse product =
      
        		productClient.getProductById(request.getProductId());

        // Calculate new total
        double totalAmount =
                product.getPrice() * request.getQuantity();

        // Update order
        order.setUserId(user.getId());
        order.setProductId(product.getId());
        order.setQuantity(request.getQuantity());
        order.setTotalAmount(totalAmount);

        Order updatedOrder = repository.save(order);

        return mapToResponse(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {

        Order order = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found with id : " + id));

        repository.delete(order);
    }

    private OrderResponse mapToResponse(Order order) {

        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .totalAmount(order.getTotalAmount())
                .build();
    }

	@Override
	public List<OrderResponse> diplayOderByUserId(Long userid) {
		return repository.findByUserId(userid)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
	}
}