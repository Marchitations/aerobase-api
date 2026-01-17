package com.aerobase.backend.repository;

import com.aerobase.backend.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {

    Aeronave searchAeronaveByNome (String nome);
}
