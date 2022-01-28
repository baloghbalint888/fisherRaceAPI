package hu.fisherRaceAPI.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String race;
    private String picutre;
    @OneToMany(mappedBy = "fish")
    @JsonIgnore
    private List<Catch> catches;


    public Fish(int id, String race, String picutre) {
        this.id = id;
        this.race = race;
        this.picutre = picutre;
    }

    public Fish() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPicutre() {
        return picutre;
    }

    public void setPicutre(String picutre) {
        this.picutre = picutre;
    }
}

