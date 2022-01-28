package hu.fisherRaceAPI.domain;

import javax.persistence.Entity;

public class Competition {
    private String fisherName;
    private int sumWeight;

    public Competition(String fisherName, int sumWeight) {
        this.fisherName = fisherName;
        this.sumWeight = sumWeight;
    }

    public Competition() {
    }

    public String getFisherName() {
        return fisherName;
    }

    public void setFisherName(String fisherName) {
        this.fisherName = fisherName;
    }

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }
}
