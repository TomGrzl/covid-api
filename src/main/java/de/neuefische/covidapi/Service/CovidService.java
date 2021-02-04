package de.neuefische.covidapi.Service;

import de.neuefische.covidapi.covid19ApiService.Covid19ApiService;
import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.model.CovidApiCountryStatusData;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CovidService {

    Covid19ApiService covid19ApiService;

    public CovidService(Covid19ApiService covid19ApiService) {
        this.covid19ApiService = covid19ApiService;
    }

    public Optional<ActiveCases> getActiveCasesForHamburg() {
        CovidApiCountryStatusData[] activeCases = covid19ApiService.getActiveCases();
        for (CovidApiCountryStatusData activeCase : activeCases) {
            if (activeCase.getProvince().equals("Hamburg")) {
                return Optional.of(new ActiveCases(activeCase.getProvince(), activeCase.getDate(), activeCase.getActive()));
            }

        }
        return Optional.empty();
    }
}
