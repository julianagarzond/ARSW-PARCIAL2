package edu.eci.arsw.covidApplication.model;

import org.json.JSONObject;

public class CovidCountry {
    private JSONObject json;
    private String name;
    private int death;
    private int cure;
    private int sick;


    public CovidCountry(String country, int deaths, int confirmed, int recovered) {
        this.name=country;
        this.death=deaths;
        this.cure=recovered;
        this.sick=confirmed;
    }

    public CovidCountry(JSONObject json) {
        this.json = json;
        death = Integer.valueOf(json.get("deaths").toString());
        cure = Integer.valueOf(json.get("recovered").toString());
        sick = Integer.valueOf(json.get("confirmed").toString());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getCure() {
        return cure;
    }

    public void setCure(int cure) {
        this.cure = cure;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public JSONObject getJson(){
        json.put("deaths",death);
        json.put("confirmed",sick);
        json.put("recovered",cure);
        return json;
    }
}
