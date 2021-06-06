package shein.dmitriy.ntiteam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shein.dmitriy.ntiteam.entitys.Planet;
import shein.dmitriy.ntiteam.services.PlanetService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlanetTest {

    @Autowired
    PlanetService planetService;

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
//        size = planetService.findAll().size();
        planetService.delete(planet);
        assertThat(planetService.findById(1)).isNull();
    }
}
