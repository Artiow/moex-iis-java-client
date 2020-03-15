package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.NONE)
public class Document {

    @XmlElement(name = "data")
    private List<Data> data;
}
