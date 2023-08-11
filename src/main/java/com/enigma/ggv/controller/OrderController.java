package com.enigma.ggv.controller;

import com.enigma.ggv.entity.Film;
import com.enigma.ggv.model.request.OrderRequest;
import com.enigma.ggv.model.response.CommonResponse;
import com.enigma.ggv.model.response.OrderResponse;
import com.enigma.ggv.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.<OrderResponse>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Successfully create data")
                .data(orderService.create(orderRequest))
                .build());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<OrderResponse>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get by id")
                        .data(orderService.getById(id))
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all")
                        .data(orderService.getAll())
                        .build());
    }
}
