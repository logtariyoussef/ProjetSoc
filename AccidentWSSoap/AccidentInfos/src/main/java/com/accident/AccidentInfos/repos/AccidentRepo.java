package com.accident.AccidentInfos.repos;

import com.accident.AccidentInfos.models.Accident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepo extends JpaRepository<Accident,Long> {

     List<Accident> findAccidentByLocation(String loocation);

}
