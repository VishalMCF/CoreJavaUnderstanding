package org.embibe.demo.dashboard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetricsDTO {
    private Integer numerator;
    private Integer denominator;
    private Double percentage;

    public MetricsDTO(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        setPercentage();
    }

    private void setPercentage() {
        if (numerator == null ){
            this.percentage = 0.0;
            return;
        }
        if(denominator == null || denominator == 0){
            this.percentage = 0.0;
            return;
        }
        this.percentage = (double)numerator/denominator;
    }
}
