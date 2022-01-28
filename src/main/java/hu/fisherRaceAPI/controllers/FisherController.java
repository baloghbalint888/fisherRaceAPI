package hu.fisherRaceAPI.controllers;

import hu.fisherRaceAPI.domain.CatchList;
import hu.fisherRaceAPI.domain.Competition;
import hu.fisherRaceAPI.domain.Fisher;
import hu.fisherRaceAPI.services.FisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FisherController {

    @Autowired
    private FisherService service;

    @GetMapping("/fishers")
    public List<Fisher> getFishers(){
        return service.getFishers();
    }

    @GetMapping("/fishers/{id}")
    public Fisher getFisher(@PathVariable("id") int id){
        return service.getFisher(id);
    }

    @PostMapping("/fishers")
    @ResponseStatus(HttpStatus.CREATED)
    public Fisher addFisher(@RequestBody Fisher fisher){
        return service.addFisher(fisher);
    }

    @PatchMapping("/fishers/{id}")
    public Fisher updateFisher(@PathVariable("id") int id, @RequestBody Fisher fisher){
        String country = fisher.getCountry();
        return service.updateFisher(id, country);
    }

    @DeleteMapping("/fishers/{id}")
    public void deleteFisher(@PathVariable("id") int id){
        service.deleteFisher(id);
    }

    @GetMapping("/catchlist/{id}")
    public List<CatchList> getCatchList(@PathVariable("id") int id){
        return service.getCatchList(id);
    }

    @GetMapping("/comp")
    public List<Competition> comp(){
        return service.competition();
    }



}
