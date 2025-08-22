package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SaleSummaryDTO {

    private String sallerName;
    private Double total;

    public SaleSummaryDTO(String sallerName, Double total) {
        this.sallerName = sallerName;
        this.total = total;
    }

    public SaleSummaryDTO() {}

    public SaleSummaryDTO(Sale sale) {
        this.sallerName = sale.getSeller().getName();
        this.total = sale.getAmount();
    }

    public SaleSummaryDTO(SaleSummaryDTO dto){
        this.sallerName = dto.getSallerName();
        this.total = dto.getTotal();
    }

    public String getSallerName() {
        return sallerName;
    }

    public void setSallerName(String sallerName) {
        this.sallerName = sallerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
