package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj")
    List<SaleMinDTO> relatorioVendas(LocalDate initDate, LocalDate endDate,String salesName);

    @Query("SELECT obj FROM Sale obj")
    List<SaleMinDTO> vendaPorVendedor(LocalDate initDate, LocalDate endDate);

}
