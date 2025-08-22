package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
    Page<Sale> relatorioVendas(Pageable pageable, LocalDate minDate, LocalDate maxDate, String name);

    //@Query("SELECT obj.seller, SUM(obj.amount) FROM Sale obj INNER JOIN obj.seller seller WHERE obj.date BETWEEN :minDate AND :maxDate GROUP BY obj.seller")
    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleSummaryDTO(obj.seller.name,SUM(obj.amount)) FROM Sale obj INNER JOIN obj.seller seller WHERE obj.date BETWEEN :minDate AND :maxDate GROUP BY obj.seller")
    Page<SaleSummaryDTO> vendaPorVendedor(Pageable pageable, LocalDate minDate, LocalDate maxDate);

}
