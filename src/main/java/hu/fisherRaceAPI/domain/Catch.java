package hu.fisherRaceAPI.domain;

import javax.persistence.*;


@Entity
public class Catch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Fisher fisher;
    @ManyToOne
    private Fish fish;
    private int weight;

    public Catch(int id, Fisher fisher, Fish fish, int weight) {
        this.id = id;
        this.fisher = fisher;
        this.fish = fish;
        this.weight = weight;
    }

    public Catch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fisher getFisher() {
        return fisher;
    }

    public void setFisher(Fisher fisher) {
        this.fisher = fisher;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
