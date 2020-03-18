package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Candle {

    private String open;
    private String close;
    private String high;
    private String low;
    private String value;
    private String volume;
    private String begin;
    private String end;
}
