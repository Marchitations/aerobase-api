package com.aerobase.backend.repository;

import com.aerobase.backend.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {
    @Query("""
        SELECT a FROM Aeronave a
        WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(a.marca) LIKE LOWER(CONCAT('%', :term, '%'))
           OR LOWER(a.descricao) LIKE LOWER(CONCAT('%', :term, '%'))
           OR CAST(a.ano AS string) LIKE CONCAT('%', :term, '%')
    """)
    List<Aeronave> findByTerm(@Param("term") String term);
}
