package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.NONE)
public class Metadata {

    @XmlElementWrapper(name = "columns")
    @XmlElement(name = "column")
    private List<Column> columns;
}
