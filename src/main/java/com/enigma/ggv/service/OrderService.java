package com.enigma.ggv.service;

import com.enigma.ggv.model.request.OrderRequest;
import com.enigma.ggv.model.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderRequest orderRequest);
    OrderResponse getById(String id);
    List<OrderResponse> getAll();
}
