package me.yassu.start.start_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Integer homeId;

    @Column(name = "owner_name", nullable = false)
    private String ownerName;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @Column(name = "number_of_people", nullable = false)
    private int numberOfPeople;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "last_update_date")
    private Date updatedDate;

    public Home() {
    }

    public Home(String ownerName, String cityName, String stateName, int numberOfPeople, Date createdDate, Date updatedDate) {
        this.ownerName = ownerName;
        this.cityName = cityName;
        this.stateName = stateName;
        this.numberOfPeople = numberOfPeople;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
