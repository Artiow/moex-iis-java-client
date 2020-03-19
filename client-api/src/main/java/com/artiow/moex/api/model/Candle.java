package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Candle {

    private BigDecimal open;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal value;
    private BigDecimal volume;
    private LocalDateTime begin;
    private LocalDateTime end;
}
