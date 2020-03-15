package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

@Getter
@Setter
@XmlRootElement(name = "column")
@XmlAccessorType(XmlAccessType.NONE)
public class Column {

    @XmlAttribute(name = "name", required = true)
    private QName name;

    @XmlAttribute(name = "type", required = true)
    private String type;

    @XmlAttribute(name = "bytes")
    private Integer bytes;

    @XmlAttribute(name = "max_size")
    private Integer maxSize;
}
