package me.yassu.start.start_project.dto;

import java.io.Serial;
import java.io.Serializable;

public class HomeResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String ownerName;
    private String cityName;
    private String stateName;
    private String numberOfPeople;

    public HomeResponseDTO() {
    }

    public HomeResponseDTO(String id, String ownerName, String cityName, String stateName, String numberOfPeople) {
        this.id = id;
        this.ownerName = ownerName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.numberOfPeople = numberOfPeople;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(String numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
