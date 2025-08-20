package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	private final SaleRepository repository;
    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

    public Page<SaleReportDTO> relatorioVendas(Pageable pageable, String minDate, String maxDate, String name) {

        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate defaultInitDate = today.minusYears(1L);
        if(maxDate == null) {
            maxDate = today.toString();
        } else if ( minDate == null) {
            minDate = defaultInitDate.toString();
        }
        Page<Sale> result = repository.relatorioVendas(pageable,minDate,maxDate,name);
        return result.map(SaleReportDTO::new);
    }
}
