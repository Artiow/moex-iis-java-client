package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class SecurityPaperBoard {

    private String secid;
    private String boardid;
    private String title;
    private Integer boardGroupId;
    private Integer marketId;
    private String market;
    private Integer engineId;
    private String engine;
    private Boolean isTraded;
    private Integer decimals;
    private LocalDate historyFrom;
    private LocalDate historyTill;
    private LocalDate listedFrom;
    private LocalDate listedTill;
    private Boolean isPrimary;
    private String currencyid;
}
