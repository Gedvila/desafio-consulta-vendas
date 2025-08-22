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

        try {
            Page<Sale> result = repository.relatorioVendas(pageable,LocalDate.parse(minDate),LocalDate.parse(maxDate),name);
            return result.map(SaleReportDTO::new);
        } catch (Exception e){
            LocalDate defaulMaxDate = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
            LocalDate defaultMinDate =  defaulMaxDate.minusYears(1L);

            Page<Sale> result = repository.relatorioVendas(pageable,defaultMinDate,defaulMaxDate,name);
            return result.map(SaleReportDTO::new);
        }

    }
}
