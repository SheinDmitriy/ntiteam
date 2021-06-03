package shein.dmitriy.ntiteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.ntiteam.repositories.PlanetRepository;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }
}
