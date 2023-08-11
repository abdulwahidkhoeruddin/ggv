package com.enigma.ggv.repository;

import com.enigma.ggv.entity.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface StudioRepository extends JpaRepository<Studio, String> {
    @Query(value = "SELECT * FROM m_studio", nativeQuery = true)
    List<Studio> findAll();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM m_studio WHERE id = :id", nativeQuery = true)
    void deleteById(String id);
}
