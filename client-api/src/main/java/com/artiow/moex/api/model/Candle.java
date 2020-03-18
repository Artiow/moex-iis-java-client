package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Candle {

    private Double open;
    private Double close;
    private Double high;
    private Double low;
    private Double value;
    private Double volume;
    private LocalDateTime begin;
    private LocalDateTime end;
}
