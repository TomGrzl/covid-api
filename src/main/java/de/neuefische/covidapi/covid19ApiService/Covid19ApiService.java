package de.neuefische.covidapi.covid19ApiService;

import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.model.CovidApiCountryStatusData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Covid19ApiService {

    private final RestTemplate restTemplate;
    private final String url = "https://api.covid19api.com/live/country/germany/status/active/date/2021-01-25T00:00:00";

    public Covid19ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CovidApiCountryStatusData[] getActiveCases() {
       ResponseEntity<CovidApiCountryStatusData[]> response = restTemplate.getForEntity(url, CovidApiCountryStatusData[].class);
       return response.getBody();
    }
}
