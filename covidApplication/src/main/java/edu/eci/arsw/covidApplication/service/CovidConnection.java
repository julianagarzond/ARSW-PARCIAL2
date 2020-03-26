package edu.eci.arsw.covidApplication.service;

import com.mashape.unirest.http.HttpResponse;
import org.springframework.stereotype.Service;
import com.mashape.unirest.http.exceptions.UnirestException;

import com.mashape.unirest.http.Unirest;

@Service
public class CovidConnection {
    public String getAllCases() throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "0e72bcd144msh8951afd83016cbbp115df0jsnf8ca2e9da0ec")
                .asString();
        return response.getBody();
    }
}
