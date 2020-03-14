package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Integer id;
    private String boardid;
    private String title;
    private Integer isTraded;
}
