package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SallerSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :minDate AND :maxDate AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%',:name,'%'))")
    Page<Sale> relatorioVendas(Pageable pageable, String minDate, String maxDate, String name);

//    @Query("SELECT new com.devsuperior.dsmeta.dto.SallerSummaryDTO(obj.seller.name) FROM Sale obj WHERE obj.date BETWEEN :initDate AND :endDate")
//    List<SallerSummaryDTO> vendaPorVendedor(String initDate, String endDate);

}
