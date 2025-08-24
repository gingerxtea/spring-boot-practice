package me.yassu.start.start_project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class HomeRequestDTO {

    @NotBlank(message = "Owner Name should not be empty")
    private String ownerName;

    @NotBlank(message = "City Name should not be empty")
    private String cityName;

    @NotBlank(message = "State Name should not be empty")
    private String stateName;

    @Positive(message = "Number of people must be greater than 0")
    private int numberOfPeople;

    public HomeRequestDTO() {
    }

    public HomeRequestDTO(String ownerName, String cityName, String stateName, int numberOfPeople) {
        this.ownerName = ownerName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.numberOfPeople = numberOfPeople;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
