package de.neuefische.covidapi.covidApi19Service;


import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.model.CovidApiStatusData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class CovidApiService {


    private final RestTemplate restTemplate;
    private final String url = "https://api.covid19api.com/live/country/germany/status/confirmed/date/2021-02-01T13:13:30Z";


    public CovidApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CovidApiStatusData[] getActiveCases() {
        ResponseEntity<CovidApiStatusData[]> response = restTemplate.getForEntity(url, CovidApiStatusData[].class);
        return response.getBody();
    }


}
