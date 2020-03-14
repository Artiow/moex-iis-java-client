package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

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
    private Integer isTraded;
    private Integer decimals;
    private Date historyFrom;
    private Date historyTill;
    private Date listedFrom;
    private Date listedTill;
    private Integer isPrimary;
    private String currencyid;
}
