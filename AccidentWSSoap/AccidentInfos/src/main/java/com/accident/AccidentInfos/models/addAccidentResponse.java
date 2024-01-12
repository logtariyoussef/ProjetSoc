package com.accident.AccidentInfos.models;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "", propOrder = {
        "accident"
})
@XmlRootElement(name = "addAccidentResponse")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class addAccidentResponse {

    @XmlElement(name = "id", required = true)
    protected Long id;
    @XmlElement(name = "location", required = true)
    protected String location;
    @XmlElement(name = "time", required = true)
    protected String time;


}