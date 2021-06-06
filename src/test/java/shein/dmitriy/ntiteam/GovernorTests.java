package shein.dmitriy.ntiteam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import shein.dmitriy.ntiteam.entitys.Governor;
import shein.dmitriy.ntiteam.services.GovernorService;
import shein.dmitriy.ntiteam.services.PlanetService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

@SpringBootTest
class GovernorTests {

    @Autowired
    private GovernorService governorService;

    @Test
    void governorFindByIdTest() {
        Governor governor = governorService.findById(1);
        assertThat(governor.getGovernorId()).isEqualTo(1);
    }

    @Test
    void governorTopTest() {
        List<Governor> listGovernor = governorService.top10();
        assertThat(listGovernor.size()).isEqualTo(10);
        assertThat(listGovernor.get(0).getAge()).isLessThanOrEqualTo(listGovernor.get(1).getAge());
        for (int i=0; i < (listGovernor.size() - 1); i++){
            assertThat(listGovernor.get(i).getAge()).isLessThanOrEqualTo(listGovernor.get(i + 1).getAge());
        }
    }

    @Test
    void governorSlackersTest(){
        List<Governor> listGovernor = governorService.slackers();
        for (Governor g: listGovernor) {
            assertThat(g.getPlanets()).isEmpty();
        }
    }

    @Test
    void governorSaveTest(){
        Governor governor = new Governor();
        governor.setName("test");
        governor.setAge((short) 1);
        int size = governorService.findAll().size();
        governorService.save(governor);
        assertThat(governorService.findAll().size() - size).isEqualTo(1);
    }
}
