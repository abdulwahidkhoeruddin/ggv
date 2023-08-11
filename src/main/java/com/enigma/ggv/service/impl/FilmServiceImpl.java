package com.enigma.ggv.service.impl;

import com.enigma.ggv.entity.Film;
import com.enigma.ggv.repository.FilmRepository;
import com.enigma.ggv.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Override
    public Film create(Film film) {
        try {
            return filmRepository.saveAndFlush(film);
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public Film getById(String id) {
        List<Film> films = getAll();
        return films.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));
    }

    @Override
    public List<Film> getAll() {
        return filmRepository.findAll();
    }

    @Override
    public Film update(Film film) {
        getById(film.getId());
        try {
            return filmRepository.save(film);
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        filmRepository.deleteById(id);
    }
}
