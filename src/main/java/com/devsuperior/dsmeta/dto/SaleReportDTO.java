package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

import java.time.LocalDate;

public class SaleReportDTO {

    private Long id;
    private LocalDate data;
    private Double qtdVendas;
    private String salesName;

    public SaleReportDTO(Long id, LocalDate data, Double qtdVendas, String salesName) {
        this.id = id;
        this.data = data;
        this.qtdVendas = qtdVendas;
        this.salesName = salesName;
    }

    public SaleReportDTO(){}

    public SaleReportDTO(Sale sale){
        this.id = sale.getId();
        this.data = sale.getDate();
        this.qtdVendas = sale.getAmount();
        this.salesName = sale.getSeller().getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getQtdVendas() {
        return qtdVendas;
    }

    public void setQtdVendas(Double qtdVendas) {
        this.qtdVendas = qtdVendas;
    }

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }
}
