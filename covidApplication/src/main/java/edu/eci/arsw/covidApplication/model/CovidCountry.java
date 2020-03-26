package edu.eci.arsw.covidApplication.model;

public class CovidCountry {

    private String name;
    private int death;
    private int cure;
    private int sick;

    public CovidCountry(String country, int death, int sick, int cure) {
        this.name=country;
        this.death=death;
        this.cure=cure;
        this.sick=sick;
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


}
