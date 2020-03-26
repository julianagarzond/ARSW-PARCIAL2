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
                .header("x-rapidapi-key", "da440f3495msh248209649ef16b1p17efcajsn78a0f7634941")
                .asString();
        return response.getBody();
    }


    public String getCasesByCountry(String countryName) throws UnirestException{

        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+countryName)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "da440f3495msh248209649ef16b1p17efcajsn78a0f7634941")
                .asString();
        return response.getBody();
    }


}

