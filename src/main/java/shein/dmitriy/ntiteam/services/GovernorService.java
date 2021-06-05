package shein.dmitriy.ntiteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shein.dmitriy.ntiteam.entitys.Governor;
import shein.dmitriy.ntiteam.repositories.GovernorRepository;

import java.util.List;

@Service
public class GovernorService {
    private GovernorRepository governorRepository;

    @Autowired
    public GovernorService(GovernorRepository governorRepository) {
        this.governorRepository = governorRepository;
    }

    public List<Governor> findAll() {
        return governorRepository.findAll();
    }

    @Transactional
    public void save(Governor governor) {
        governorRepository.save(governor);
    }

    public Governor findById(int id){
        return governorRepository.findByGovernorId(id);
    }

    public List<Governor> slackers() {
        return governorRepository.findGovernorsByPlanetsIsNull();
    }

//    public List<Governor> top10() {
//        return governorRepository.findFirst10ByAgeOrderByAge();
//    }
}
