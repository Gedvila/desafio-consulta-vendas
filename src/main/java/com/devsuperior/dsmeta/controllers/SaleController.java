package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleReportDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	private final SaleService service;
    public SaleController(SaleService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/summary")
	public ResponseEntity<Page<SaleSummaryDTO>> getSummary(Pageable pageable, @RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate) {
        Page<SaleSummaryDTO> dto = service.relatorioVendedores(pageable, minDate,maxDate);
		return ResponseEntity.ok(dto);
	}

    @GetMapping(value = "/report")
    public ResponseEntity<Page<SaleReportDTO>> getReport(Pageable pageable, @RequestParam(required = false) String minDate, @RequestParam(required = false) String maxDate, @RequestParam(defaultValue = "") String name) {
        Page<SaleReportDTO> dto = service.relatorioVendas(pageable,minDate,maxDate,name);
        return ResponseEntity.ok(dto);
    }
}
