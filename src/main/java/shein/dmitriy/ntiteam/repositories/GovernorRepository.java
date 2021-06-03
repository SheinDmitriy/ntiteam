package shein.dmitriy.ntiteam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import shein.dmitriy.ntiteam.entitys.Governor;

import java.util.List;

@Repository
public interface GovernorRepository extends CrudRepository<Governor, Integer> {
    List<Governor> findAll();
}
