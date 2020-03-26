package edu.eci.arsw.covidApplication.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.covidApplication.model.CovidCountry;
import edu.eci.arsw.covidApplication.persistence.CovidException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CovidService {
    @Autowired
    CovidConnection cc;
    public String getAllCases() throws CovidException {
        String info;
        JSONArray countries = new JSONArray();
        Map<String, CovidCountry> cases = new HashMap<>();
        try {
            info = cc.getAllCases();
            JSONObject newInfo = new JSONObject(info);
            JSONObject data = new JSONObject(newInfo.get("data").toString());
            JSONArray covid = new JSONArray(data.get("covid19Stats").toString());
            for(int i = 0;i<covid.length();i++){
                JSONObject myobject = (JSONObject) covid.get(i);
                 boolean flag=cases.containsKey(myobject.get("country").toString());
                if(flag==false){
                    cases.put(myobject.get("country").toString(),new CovidCountry(myobject));
                } else {
                    cases.get(myobject.get("country").toString());
                }
            }
            for(String string:cases.keySet()){
                countries.put(cases.get(string).getJson());
            }
            info= countries.toString();
        } catch ( UnirestException e) {
            throw new CovidException(e.getMessage());
        }
        return info;
    }

    public String getCasesByCountry(String countryName) throws CovidException {
        String info;
        JSONArray countries = new JSONArray();
        try{
            info = cc.getCasesByCountry(countryName);
            JSONObject newInfo = new JSONObject(info);
            JSONObject data = new JSONObject(newInfo.get("data").toString());
            JSONArray covid = new JSONArray(data.get("covid19Stats").toString());
            for(int i = 0;i<covid.length();i++){
                JSONObject myobject = (JSONObject) covid.get(i);
                countries.put(myobject);


            }
            info= countries.toString();
        } catch ( UnirestException e) {
            throw new CovidException(e.getMessage());
        }
        return info;
        }


    }

