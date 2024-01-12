package com.accident.AccidentInfos.services;


import com.accident.AccidentInfos.models.Accident;
import com.accident.AccidentInfos.repos.AccidentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {

    private final AccidentRepo accidentRepo;

    public AccidentService(AccidentRepo accidentRepo) {
        this.accidentRepo = accidentRepo;
    }

    public Accident saveAccident(Accident accident){
        return accidentRepo.save(accident);
    }

    public List<Accident> getAllAccidents(){
       return  this.accidentRepo.findAll();
    }

    public List<Accident> findAccidentByLocation(String location){
        return this.accidentRepo.findAccidentByLocation(location);
    }

}
