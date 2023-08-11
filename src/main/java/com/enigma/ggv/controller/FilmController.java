package com.enigma.ggv.controller;

import com.enigma.ggv.entity.Film;
import com.enigma.ggv.model.response.CommonResponse;
import com.enigma.ggv.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/film")
public class FilmController {
    private final FilmService filmService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Film film){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<Film>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Successfully create data")
                .data(filmService.create(film))
                .build());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Film>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully get by id")
                .data(filmService.getById(id))
                .build());
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully get all")
                .data(filmService.getAll())
                .build());
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Film>builder()
                .statusCode(HttpStatus.OK.value())
                .message("Successfully update data")
                .data(filmService.update(film))
                .build());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        filmService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.<String>builder()
            .statusCode(HttpStatus.OK.value())
            .message("Successfully delete data")
            .build());
    }
}
