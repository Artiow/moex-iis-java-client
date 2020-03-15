package com.artiow.moex.api.model.schema;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import java.util.Map;

@Getter
@Setter
@XmlRootElement(name = "row")
@XmlAccessorType(XmlAccessType.NONE)
public class Row {

    @XmlAnyAttribute
    private Map<QName, String> attributes;
}
