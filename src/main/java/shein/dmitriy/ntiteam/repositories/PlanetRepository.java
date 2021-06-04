package shein.dmitriy.ntiteam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shein.dmitriy.ntiteam.entitys.Planet;

import java.util.List;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Integer> {
    List<Planet> findAll();
}
