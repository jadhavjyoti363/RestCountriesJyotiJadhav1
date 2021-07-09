package com.example.restcountries.ModelClass;
//created by Jyoti Jadhav

public class RestCountries {

    String Name;
    String Capital;
    String Flag;
    String Region;
    String  Subregion;
    String Population;
    String Borders;
    String Language;

    public RestCountries(String name, String capital, String flag, String region, String subregion, String population, String borders, String language) {
        Name = name;
        Capital = capital;
        Flag = flag;
        Region = region;
        Subregion = subregion;
        Population = population;
        Borders = borders;
        Language = language;
    }

    public RestCountries() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getSubregion() {
        return Subregion;
    }

    public void setSubregion(String subregion) {
        Subregion = subregion;
    }

    public String getPopulation() {
        return Population;
    }

    public void setPopulation(String population) {
        Population = population;
    }

    public String getBorders() {
        return Borders;
    }

    public void setBorders(String borders) {
        Borders = borders;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }
}
