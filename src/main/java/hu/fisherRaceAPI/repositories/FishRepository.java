package hu.fisherRaceAPI.repositories;

import hu.fisherRaceAPI.domain.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FishRepository extends JpaRepository<Fish, Integer> {


    @Query(value="SELECT fish.id, fish.race, fish.picture, SUM(catch.weight) AS sumweight " +
            "FROM fish INNER JOIN catch ON fish.id=catch.fish " +
            "GROUP BY fish.id ORDER BY sumweight DESC", nativeQuery = true)
    public List<Object[]> getFishes();
    // Nem egyeznek az oszlopok a Fish osztály példányváltozóival,
    // ezért nem lehet List<Fish> típussal visszatérni
}
