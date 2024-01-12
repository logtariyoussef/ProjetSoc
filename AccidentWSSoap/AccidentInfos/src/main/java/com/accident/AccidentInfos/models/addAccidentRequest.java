package com.accident.AccidentInfos.models;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accident"
})
@XmlRootElement(name = "addAccidentRequest")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class addAccidentRequest {

    @XmlElement(name = "location", required = true)
    protected String location;

    @XmlElement(name = "time", required = true)
    protected String time;


}