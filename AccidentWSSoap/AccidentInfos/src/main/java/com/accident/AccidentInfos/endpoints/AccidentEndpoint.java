package com.accident.AccidentInfos.endpoints;

import com.accident.AccidentInfos.services.AccidentService;
import io.spring.guides.accidents.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Endpoint

public class AccidentEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/accidents";


    private final AccidentService accidentService;

    public AccidentEndpoint(AccidentService accidentService) {

        this.accidentService = accidentService;

    }
    //add accident

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddAccidentRequest")
    @ResponsePayload
    public AddAccidentResponse addAccident(@RequestPayload AddAccidentRequest request) {
        AddAccidentResponse addAccidentResponse = new AddAccidentResponse();
        Accident accident = new Accident();
        BeanUtils.copyProperties(request, accident);
        com.accident.AccidentInfos.models.Accident accident1 = new com.accident.AccidentInfos.models.Accident();
        BeanUtils.copyProperties(accident, accident1);
        accidentService.saveAccident(accident1);
        addAccidentResponse.setAccident(accident);
        return addAccidentResponse;
    }


    //get all accidents
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllAccidentsRequest")
    @ResponsePayload
    public GetAllAccidentsResponse getAllAciidentS(@RequestPayload GetAllAccidentsRequest request) {

        GetAllAccidentsResponse response = new GetAllAccidentsResponse();
        List<com.accident.AccidentInfos.models.Accident> accidents = accidentService.getAllAccidents();

        List<Accident> accidents1 = accidents.stream()
                .map(this::convertToAccident)
                .collect(Collectors.toList());

        Accidents accidents2 = new Accidents();
        accidents2.getAccident().addAll(accidents1);

        response.setAccidents(accidents2);
        return response;
    }


    // convert our object from database to xml
    private Accident convertToAccident(com.accident.AccidentInfos.models.Accident accident) {
        Accident accident1 = new Accident();
        accident1.setId(accident.getId());
        accident1.setLocation(accident.getLocation());
        accident1.setTime(accident.getTime());
        return accident1;
    }


    @PayloadRoot(namespace = NAMESPACE_URI , localPart = "getAccidentByLocationRequest")
    @ResponsePayload
    public GetAccidentByLocationResponse getAccidentsByLocation(@RequestPayload GetAccidentByLocationRequest request){
        GetAccidentByLocationResponse response = new GetAccidentByLocationResponse();
        List<com.accident.AccidentInfos.models.Accident> accidents = accidentService.findAccidentByLocation(request.getLocation());
        List<Accident> accidents1 = accidents.stream()
                .map(this::convertToAccident)
                .collect(Collectors.toList());

        Accidents accidents2 = new Accidents();
        accidents2.getAccident().addAll(accidents1);

        response.setAccidents(accidents2);
        return response;

    }


}

