package smartlog.authenticate.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import smartlog.core.dao.DaoFactory;
import smartlog.db.entity.OfficerMaster;
import smartlog.db.entity.Role;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.InvalidInputException;
import smartlog.exception.PhoneAlreadyExistException;
import smartlog.officer.dao.OfficerMasterDao;
import smartlog.officer.entity.CreateOfficerRequest;
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    DaoFactory daoFactory;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    @Override
    public OfficerMaster registerOfficer(CreateOfficerRequest request) throws EmailAlreadyExistException, InvalidInputException {
        logger.info("creating new user account: {}, {}", request.getEmail(), request.getPassword());

        // Mandatory field check up
        if (request.getEmail() == null || request.getEmail().length() == 0) {
            throw new InvalidInputException("Missing Email address");
        }

        if (request.getPassword() == null || request.getPassword().length() == 0) {
            throw new InvalidInputException("Missing Password");
        }

        if (request.getName() == null || request.getName().length() == 0) {
            throw new InvalidInputException("Missing user name");
        }
        if (request.getPhoneNo() == null || request.getPhoneNo().length() == 0) {
            throw new InvalidInputException("Missing Phone number");
        }

        if (request.getOfficerType() == null || request.getOfficerType().length() == 0) {
            throw new InvalidInputException("Missing officer typr");
        }

        OfficerMasterDao userDao = daoFactory.getOfficerMasterDao();
        boolean emailExist = userDao.ExistForEmail(request.getEmail());
        boolean phoneExist = userDao.existForPhone(request.getPhoneNo()) ;
        if (emailExist){
            logger.info("Email {} already exist.", request.getEmail());
            throw new EmailAlreadyExistException("Email already exist.");
        }if (phoneExist){
            logger.info("Phone number {} already exist.", request.getPhoneNo());
            throw new PhoneAlreadyExistException("Phone number already exist.");
        }
        OfficerMaster officer = new OfficerMaster();
        officer.setName(request.getName());
        officer.setEmail(request.getEmail());
        officer.setPassword(passwordEncoder.encode(request.getPassword()));
        officer.setPhoneNo(request.getPhoneNo());
        Long roleId = new Long(2);
        Role role = new Role(roleId);
        officer.setRole(role);
        officer.setOfficerType(request.getOfficerType());
        OfficerMaster newOfficer =userDao.createOfficer(officer);

        return newOfficer;
    }
}
