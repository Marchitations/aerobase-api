package com.aerobase.backend.repository;

import com.aerobase.backend.model.AeronaveHistorico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AeronaveHistoricoRepository extends JpaRepository<AeronaveHistorico, Long> {

     List<AeronaveHistorico> findByAeronaveIdOrderByDataAlteracaoDesc(Long aeronaveId);
}
