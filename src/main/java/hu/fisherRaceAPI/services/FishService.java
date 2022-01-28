package hu.fisherRaceAPI.services;

import hu.fisherRaceAPI.domain.Fish;
import hu.fisherRaceAPI.domain.FishList;
import hu.fisherRaceAPI.repositories.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FishService {

    @Autowired
    private FishRepository repository;
    @Value("${server.port}")
    private int port;

    public List<FishList> getFishes() {
        List<FishList> fishes = new ArrayList<>();
        List<Object[]> data = repository.getFishes();
        for (Object[] object : data) {
            int id = (Integer)object[0];
            String race = (String) object[1];
            String picture = "http://localhost:"+port+"/pics/"+(String) object[2];
            BigDecimal b = (BigDecimal) object[3];
            int sumweight = b.intValue();
            fishes.add(new FishList(id, race, picture, sumweight));
        }
        return fishes;
    }
}
