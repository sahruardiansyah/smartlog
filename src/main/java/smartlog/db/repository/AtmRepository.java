package smartlog.db.repository;

import org.springframework.data.repository.CrudRepository;
import smartlog.db.entity.AtmMaster;

public interface AtmRepository extends CrudRepository<AtmMaster, Long> {
}
