package com.enigma.ggv.service;

import com.enigma.ggv.entity.Studio;

import java.util.List;

public interface StudioService {
    Studio create(Studio studio);
    Studio getById(String id);
    List<Studio> getAll();
    Studio update(Studio studio);
    void deleteById(String id);
}
