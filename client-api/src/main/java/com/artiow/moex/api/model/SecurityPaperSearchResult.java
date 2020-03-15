package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityPaperSearchResult {

    private Integer id;
    private String secid;
    private String shortname;
    private String regnumber;
    private String name;
    private String isin;
    private Boolean isTraded;
    private Integer emitentId;
    private String emitentTitle;
    private String emitentInn;
    private String emitentOkpo;
    private String gosreg;
    private String type;
    private String group;
    private String primaryBoardid;
    private String marketpriceBoardid;
}
