package hu.fisherRaceAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Fisher {
    @Id
    private int startNumber;
    private String name;
    private String country;
    private String picture;
    @OneToMany(mappedBy = "fisher")
    @JsonIgnore
    private List<Catch> catches;

    public Fisher() {
    }

    public Fisher(int startNumber, String name, String country, String picture) {
        this.startNumber = startNumber;
        this.name = name;
        this.country = country;
        this.picture = picture;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
