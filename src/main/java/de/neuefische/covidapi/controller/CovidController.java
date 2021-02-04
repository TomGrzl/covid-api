package de.neuefische.covidapi.controller;

import de.neuefische.covidapi.model.ActiveCases;
import de.neuefische.covidapi.service.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("covidCases")
public class CovidController {

    CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("province")
    public ActiveCases getCasesForProvince(@RequestParam String province){
        if(covidService.getActiveCasesProvince(province).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return covidService.getActiveCasesProvince(province).get();
    }

    @GetMapping
    public List<ActiveCases> getCasesForAll(){
      if(covidService.getActiveCasesAll().isEmpty()) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      //get() holt Liste aus dem Optional-Objekt raus
      return covidService.getActiveCasesAll().get();
    }


}
