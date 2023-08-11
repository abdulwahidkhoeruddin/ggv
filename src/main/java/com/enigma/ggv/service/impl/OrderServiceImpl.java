package com.enigma.ggv.service.impl;

import com.enigma.ggv.entity.Film;
import com.enigma.ggv.entity.Order;
import com.enigma.ggv.entity.Studio;
import com.enigma.ggv.model.request.OrderRequest;
import com.enigma.ggv.model.response.OrderResponse;
import com.enigma.ggv.repository.OrderRepository;
import com.enigma.ggv.service.FilmService;
import com.enigma.ggv.service.OrderService;
import com.enigma.ggv.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final StudioService studioService;
    private final FilmService filmService;

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        Film film = filmService.getById(orderRequest.getFilmId());

        Order order = Order.builder()
            .film(film)
            .jumlahTiket(orderRequest.getJumlahTiket())
            .hargaBayar(45_000)
            .biayaLayanan(2000)
            .build();
        orderRepository.saveAndFlush(order);

        return getResponse(order, film);
    }

    private static OrderResponse getResponse(Order order, Film film) {
        return OrderResponse.builder()
            .kodeOrder(order.getId())
            .namaStudio(film.getStudio().getNama())
            .namaFilm(film.getNama())
            .jamTayang(film.getStudio().getTanggalTayang().toString())
            .jumlahTiket(order.getJumlahTiket())
            .hargaBayar(order.getHargaBayar())
            .biayaLayanan(order.getBiayaLayanan())
            .totalBayar((order.getHargaBayar() * order.getJumlahTiket()) + order.getBiayaLayanan())
            .build();
    }

    @Override
    public OrderResponse getById(String id) {
        List<Order> getAll = orderRepository.findAll();
        Order currentOrder = getAll.stream().
                filter(order -> order.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));

        return getResponse(currentOrder, currentOrder.getFilm());
    }

    @Override
    public List<OrderResponse> getAll() {
        List<Order> getAll = orderRepository.findAll();

        return getAll.stream().map(order -> {
            return getResponse(order, order.getFilm());
        }).collect(Collectors.toList());
    }
}
