package com.artiow.moex.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SecurityPaperSpecification {

    private SecurityPaperDescription description;
    private List<SecurityPaperBoard> boards;
}
