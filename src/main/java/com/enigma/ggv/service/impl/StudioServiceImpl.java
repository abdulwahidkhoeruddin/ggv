package com.enigma.ggv.service.impl;

import com.enigma.ggv.entity.Studio;
import com.enigma.ggv.repository.StudioRepository;
import com.enigma.ggv.service.StudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudioServiceImpl implements StudioService {
    private final StudioRepository studioRepository;

    @Override
    public Studio create(Studio studio) {
        try {
            return studioRepository.saveAndFlush(studio);
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public Studio getById(String id) {
        List<Studio> studios = getAll();
        return studios.stream()
                .filter(studio -> studio.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Data not found"));
    }

    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }

    @Override
    public Studio update(Studio studio) {
        getById(studio.getId());
        try {
            return studioRepository.save(studio);
        }catch (DataIntegrityViolationException e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @Override
    public void deleteById(String id) {
        getById(id);
        studioRepository.deleteById(id);
    }
}
