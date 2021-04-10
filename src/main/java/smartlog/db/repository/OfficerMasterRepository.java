package smartlog.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import smartlog.db.entity.OfficerMaster;

import java.util.Optional;

@Repository
public interface OfficerMasterRepository extends CrudRepository<OfficerMaster, Long> {
    OfficerMaster findByName(String name);
    OfficerMaster findByEmail(String email);
    Optional<OfficerMaster> findById(Long id);
    Boolean existsByEmail(String email);
    Boolean existsByPhoneNo(String phoneNo);

}
