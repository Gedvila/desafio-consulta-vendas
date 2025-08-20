package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;

public class SallerSummaryDTO {

    private String salesName;
    private Integer qtdVendas;

    public SallerSummaryDTO(String salesName, Integer qtdVendas) {
        this.salesName = salesName;
        this.qtdVendas = qtdVendas;
    }

    public SallerSummaryDTO() {}

    public SallerSummaryDTO(Sale sale) {
        this.salesName = sale.getSeller().getName();
    }


}
