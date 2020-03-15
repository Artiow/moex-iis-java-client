package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.NONE)
public class Data {

    @XmlAttribute(name = "id", required = true)
    private String id;

    @XmlElement(name = "metadata", required = true)
    private Metadata metadata;

    @XmlElementWrapper(name = "rows")
    @XmlElement(name = "row")
    private List<Row> rows;
}
