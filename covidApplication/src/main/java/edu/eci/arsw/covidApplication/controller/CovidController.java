package edu.eci.arsw.covidApplication.controller;



import edu.eci.arsw.covidApplication.persistence.CovidException;
import edu.eci.arsw.covidApplication.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/covid19")
public class CovidController {
    @Autowired
    CovidService covidService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllCasesFilter(){
        try {
            return new ResponseEntity<>(covidService.getAllCases(), HttpStatus.ACCEPTED);
        } catch ( CovidException e){
            Logger.getLogger(CovidController.class.getName()).log(Level.SEVERE,null,e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



}