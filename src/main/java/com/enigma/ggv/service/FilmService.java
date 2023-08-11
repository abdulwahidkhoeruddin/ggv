package com.enigma.ggv.service;

import com.enigma.ggv.entity.Film;

import java.util.List;

public interface FilmService {
    Film create(Film film);
    Film getById(String id);
    List<Film> getAll();
    Film update(Film film);
    void deleteById(String id);
}
