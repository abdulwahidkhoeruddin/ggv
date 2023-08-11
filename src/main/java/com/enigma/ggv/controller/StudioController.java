package com.enigma.ggv.controller;

import com.enigma.ggv.entity.Studio;
import com.enigma.ggv.model.response.CommonResponse;
import com.enigma.ggv.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/studio")
public class StudioController {
    private final StudioService studioService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Studio studio){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<Studio>builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Successfully create data")
                        .data(studioService.create(studio))
                        .build());
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Studio>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get by id")
                        .data(studioService.getById(id))
                        .build());
    }
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully get all")
                        .data(studioService.getAll())
                        .build());
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Studio studio) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Studio>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully update data")
                        .data(studioService.update(studio))
                        .build());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        studioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<String>builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Successfully delete data")
                        .build());
    }
}
