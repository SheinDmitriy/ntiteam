package shein.dmitriy.ntiteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shein.dmitriy.ntiteam.entitys.Governor;
import shein.dmitriy.ntiteam.entitys.Planet;
import shein.dmitriy.ntiteam.repositories.PlanetRepository;

import java.util.List;

@Service
public class PlanetService {
    private PlanetRepository planetRepository;
    private GovernorService governorService;

    @Autowired
    public PlanetService(PlanetRepository planetRepository, GovernorService governorService) {
        this.planetRepository = planetRepository;
        this.governorService = governorService;
    }

    @Transactional
    public void save(Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> findAll(){
        return planetRepository.findAll();
    }

    public Planet findById(int id){
        return planetRepository.findByPlanetId(id);
    }

    public void choose(Governor governorForm, Planet planetForm) {
        Planet planet = findById(planetForm.getPlanetId());
        Governor governor = governorService.findById(governorForm.getGovernorId());
        planet.setGovernor(governor);
        planetRepository.save(planet);
    }

    @Transactional
    public void delete(Planet planet) {
        planetRepository.deleteById(planet.getPlanetId());
    }
}
