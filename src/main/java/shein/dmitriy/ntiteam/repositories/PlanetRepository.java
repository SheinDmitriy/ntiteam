package shein.dmitriy.ntiteam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shein.dmitriy.ntiteam.entitys.Planet;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Integer> {
}
