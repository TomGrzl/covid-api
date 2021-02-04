package de.neuefische.covidapi.service;

import de.neuefische.covidapi.covidApi19Service.CovidApiService;
import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.model.CovidApiStatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CovidService {

    CovidApiService covidApiService;

    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }


    public Optional<ActiveCases> getActiveCasesProvince(String province){
        CovidApiStatusData[] activeCases = covidApiService.getActiveCases();
        for (CovidApiStatusData activeCase : activeCases){
            if (activeCase.getProvince().equals(province)){
                return Optional.of(new ActiveCases(activeCase.getProvince(), activeCase.getDate(), activeCase.getActive()));
            }
        }
        return Optional.empty();
    }

    //siehe Zeichnung
    public Optional<List> getActiveCasesAll(){
        CovidApiStatusData[] activeCases = covidApiService.getActiveCases();
       List<ActiveCases> activeCasesFiltered = new ArrayList<>();
        for (CovidApiStatusData activeCase : activeCases) {
            ActiveCases cases = new ActiveCases(
                    activeCase.getProvince(),
                    activeCase.getDate(),
                    activeCase.getActive());
            activeCasesFiltered.add(cases);
        }
       return Optional.of(activeCasesFiltered);
    }

}
