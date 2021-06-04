package shein.dmitriy.ntiteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.ntiteam.entitys.Planet;
import shein.dmitriy.ntiteam.entitys.SystemPlanet;
import shein.dmitriy.ntiteam.repositories.PlanetRepository;

import java.util.List;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void save(SystemPlanet systemPlanet) {
        Planet planet = new Planet();
        planet.setName(systemPlanet.getName());
        planetRepository.save(planet);
    }

    public List<Planet> findAll(){
        return planetRepository.findAll();
    }
}
