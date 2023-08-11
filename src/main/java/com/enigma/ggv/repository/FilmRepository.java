package com.enigma.ggv.repository;

import com.enigma.ggv.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, String> {
    @Query(value = "SELECT * FROM m_film", nativeQuery = true)
    List<Film> findAll();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM m_film WHERE id = :id", nativeQuery = true)
    void deleteById(String id);
}
