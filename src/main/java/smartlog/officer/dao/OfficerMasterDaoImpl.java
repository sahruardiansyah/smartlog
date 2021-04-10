package smartlog.officer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartlog.db.entity.OfficerMaster;
import smartlog.db.repository.OfficerMasterRepository;

import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OfficerMasterDaoImpl implements OfficerMasterDao {

    @Autowired
    private OfficerMasterRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(OfficerMaster.class);
    public OfficerMaster createOfficer(OfficerMaster officerMaster) {
        officerMaster.setCreatedDate(Instant.now());
        return repository.save(officerMaster);
    }

    @Override
    public OfficerMaster modifyOfficer(OfficerMaster officerMaster) throws NoSuchElementException {
        if (officerMaster.getOfficerId() ==null){
            throw new NoSuchElementException();
        }else {
            officerMaster.setModifiedDate(Instant.now());
            return repository.save(officerMaster);
        }
    }

    @Override
    public OfficerMaster findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public OfficerMaster deleteOfficer(Long id) throws NoSuchElementException {
        return null;
    }


    @Override
    public OfficerMaster findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<OfficerMaster> findById(Long id) {
        return repository.findById(id);
    }


    public void setRepository(OfficerMasterRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean ExistForEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean existForPhone(String phoneNo) {
        return repository.existsByPhoneNo(phoneNo);
    }


}
