package shein.dmitriy.ntiteam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shein.dmitriy.ntiteam.entitys.Governor;
import shein.dmitriy.ntiteam.entitys.Planet;
import shein.dmitriy.ntiteam.services.GovernorService;
import shein.dmitriy.ntiteam.services.PlanetService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlanetTest {

    @Autowired
    PlanetService planetService;
    @Autowired
    GovernorService governorService;

    @Test
    @Transactional
    void planetSaveTest(){
        Planet planet = new Planet();
        planet.setName("test");
        int size = planetService.findAll().size();
        planetService.save(planet);
        assertThat(planetService.findAll().size() - size).isEqualTo(1);
    }

    @Test
    @Transactional
    void planetDeleteTest(){
        Planet planet = planetService.findById(1);
        planetService.delete(planet);
        assertThat(planetService.findById(1)).isNull();
    }

    @Test
    void planetFindByIdTest() {
        Planet planet = planetService.findById(1);
        assertThat(planet.getPlanetId()).isEqualTo(1);
    }

    @Test
    @Transactional
    void choosePlanetTest(){
        Governor governor = governorService.findById(2);
        Planet planet = planetService.findById(1);
        planetService.choose(governor, planet);
        assertThat(planetService.findById(1).getGovernor().getGovernorId()).isEqualTo(2);
    }
}
