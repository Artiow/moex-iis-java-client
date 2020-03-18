package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private Integer id;
    private Integer boardGroupId;
    private String boardid;
    private String title;
    private Boolean isTraded;
}
