package hu.fisherRaceAPI.services;

import hu.fisherRaceAPI.domain.CatchList;
import hu.fisherRaceAPI.domain.Competition;
import hu.fisherRaceAPI.domain.Fisher;
import hu.fisherRaceAPI.repositories.FisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FisherService {

    @Autowired
    private FisherRepository repository;

    public List<Fisher> getFishers() {
        return repository.nativeFindFishers();
    }

    public Fisher getFisher(int id){
        Optional<Fisher> fisher = repository.findById(id);
        if(fisher.isPresent())
            return fisher.get();
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public Fisher updateFisher(int id, String country) {
        Optional<Fisher> optionalFisher = repository.findById(id);
        if(optionalFisher.isPresent()){
            Fisher fisher = optionalFisher.get();
            fisher.setCountry(country);
            return repository.save(fisher);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }


    public Fisher addFisher(Fisher fisher){
        Optional<Fisher> optionalFisher = repository.findById(fisher.getStartNumber());
        if(!optionalFisher.isPresent()){
            return repository.save(fisher);
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT);
    }

    public void deleteFisher(int id) {
        Optional<Fisher> optionalFisher = repository.findById(id);
        if(optionalFisher.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<CatchList> getCatchList(int id) {
        List<CatchList> result = new ArrayList<>();
        List<Object[]> catchLists = repository.catchList(id);
        for (Object[] tomb : catchLists) {
            String fishName = (String) tomb[0];
            BigDecimal bigDecimal = (BigDecimal) tomb[1];
            int sumWeight = bigDecimal.intValue();
            result.add(new CatchList(fishName, sumWeight));
        }
        return result;
    }

    public List<Competition> competition(){
        List<Competition> result = new ArrayList<>();
        List<Object[]> comps = repository.competition();
        for (Object[] tomb : comps) {
            String fisherName = (String) tomb[0];
            BigDecimal bigDecimal = (BigDecimal) tomb[1];
            int sumWeight = 0;
            if(bigDecimal!=null) // mert lehet, hogy nem fogott még semmit és LEFT JOIN-nal kérdezzük le, mert látni akarjuk azt is, aki még nem fogott halat
                sumWeight = bigDecimal.intValue();
            result.add(new Competition(fisherName, sumWeight));
        }
        return result;
    }

}
