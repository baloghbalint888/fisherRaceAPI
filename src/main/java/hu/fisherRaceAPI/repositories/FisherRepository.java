package hu.fisherRaceAPI.repositories;

import hu.fisherRaceAPI.domain.CatchList;
import hu.fisherRaceAPI.domain.Fisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FisherRepository extends JpaRepository<Fisher, Integer> {
    public List<Fisher> findAllByOrderByName();

    @Query(value="SELECT * FROM fisher ORDER BY name ASC", nativeQuery = true)
    public List<Fisher> nativeFindFishers();

    @Query(value="SELECT fisher.name, SUM(catch.weight) AS sumweight FROM fisher LEFT JOIN catch ON fisher.start_number = catch.fisher GROUP BY fisher.start_number ORDER BY sumweight DESC", nativeQuery = true)
    public List<Object[]> competition();
    // Nem térhet vissza List<Competition> típussal,
    // mert ebben az interfészben csak a Fisher vezérelt osztályt lehet így kezelni
    // Ha a Competition osztályból @Entity és @Id annotációkkal vezérelt osztályt készítünk,
    // és saját repository interfészt kap, akkor abban nem kellen List<Object[]>,
    // de nem biztos, hogy megéri a fáradságot.

    @Query(value="SELECT fish.race, SUM(catch.weight) AS sumweight FROM fish INNER JOIN catch ON fish.id=catch.fish INNER JOIN fisher ON catch.fisher = fisher.start_number WHERE fisher.start_number = ?1 GROUP BY fish.id ORDER BY sumweight DESC", nativeQuery = true)
    public List<Object[]> catchList(int startnumber);
}
