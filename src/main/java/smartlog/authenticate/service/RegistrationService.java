package smartlog.authenticate.service;

import smartlog.db.entity.OfficerMaster;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.InvalidInputException;
import smartlog.officer.entity.CreateOfficerRequest;

public interface RegistrationService {
    public OfficerMaster registerOfficer(CreateOfficerRequest request)throws EmailAlreadyExistException, InvalidInputException;;
}
