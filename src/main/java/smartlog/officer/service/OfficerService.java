package smartlog.officer.service;

import antlr.collections.List;
import smartlog.db.entity.OfficerMaster;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.InvalidInputException;

import java.util.NoSuchElementException;
import java.util.Optional;

public interface OfficerService {
    public OfficerMaster processCreateOfficer(OfficerMaster officerMaster)throws EmailAlreadyExistException;
    public OfficerMaster processModifyOfficer(OfficerMaster officerMaster)throws NoSuchElementException;
    public OfficerMaster findByUserName (String userName) ;
    public OfficerMaster findByemail(String email);
    public Boolean existsByEmail(String email);
    Optional<OfficerMaster> findById(Long id);
}
