package hu.fisherRaceAPI.controllers;

import hu.fisherRaceAPI.domain.Fish;
import hu.fisherRaceAPI.domain.FishList;
import hu.fisherRaceAPI.services.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FishController {

    @Autowired
    private FishService service;

    @GetMapping("/fishes")
    public List<FishList> getFishes(){
        return service.getFishes();
    }
}
