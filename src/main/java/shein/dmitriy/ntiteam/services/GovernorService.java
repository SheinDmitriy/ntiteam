package shein.dmitriy.ntiteam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shein.dmitriy.ntiteam.repositories.GovernorRepository;

@Service
public class GovernorService {
    private GovernorRepository governorRepository;

    @Autowired
    public GovernorService(GovernorRepository governorRepository) {
        this.governorRepository = governorRepository;
    }
}
