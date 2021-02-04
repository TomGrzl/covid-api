package de.neuefische.covidapi.controller;

import de.neuefische.covidapi.Service.CovidService;
import de.neuefische.covidapi.model.ActiveCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("covidCases")
public class CovidController {


    CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("Hamburg")
    public ActiveCases getCasesForHamburg() {
      if (covidService.getActiveCasesForHamburg().isEmpty()) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

      return covidService.getActiveCasesForHamburg().get();
        }
    }



