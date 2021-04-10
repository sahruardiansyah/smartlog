package smartlog.officer.dao;

import smartlog.db.entity.OfficerMaster;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface OfficerMasterDao {
    public OfficerMaster createOfficer(OfficerMaster officerMaster);
    public OfficerMaster modifyOfficer(OfficerMaster officerMaster)throws NoSuchElementException;
    public OfficerMaster findByEmail(String email);
    public OfficerMaster deleteOfficer(Long id) throws NoSuchElementException;
    public OfficerMaster findByName (String name);
    public Optional<OfficerMaster> findById(Long id);
    public boolean ExistForEmail(String email);
    public boolean existForPhone(String phoneNo);
}
