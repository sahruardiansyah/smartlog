package smartlog.officer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import smartlog.core.dao.DaoFactory;
import smartlog.db.entity.OfficerMaster;
import smartlog.exception.EmailAlreadyExistException;
import smartlog.exception.PhoneAlreadyExistException;
import smartlog.officer.dao.OfficerMasterDao;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class OfficerServiceImpl implements OfficerService {
    @Autowired
    DaoFactory daoFactory;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(OfficerServiceImpl.class);

    @Override
    public OfficerMaster processCreateOfficer(OfficerMaster officerMaster) throws EmailAlreadyExistException {
        logger.info("process create Officer: {}", officerMaster.getName());
        OfficerMasterDao dao=daoFactory.getOfficerMasterDao();
        boolean emailAlreadyExist = dao.ExistForEmail(officerMaster.getEmail());
        boolean phoneExist = dao.existForPhone(officerMaster.getPhoneNo()) ;
        if (emailAlreadyExist){
            logger.info("Email {} already exist", officerMaster.getEmail());
            throw new EmailAlreadyExistException("Email Already Exist!");
        }
        if (phoneExist){
            logger.info("Phone number {} already exist.", officerMaster.getPhoneNo());
            throw new PhoneAlreadyExistException("Phone number already exist.");
        }

        officerMaster.setPassword(passwordEncoder.encode(officerMaster.getPassword()));
        return daoFactory.getOfficerMasterDao().createOfficer(officerMaster);
    }

    @Override
    public OfficerMaster processModifyOfficer(OfficerMaster officerMaster) throws NoSuchElementException {
        OfficerMaster existOfficer =daoFactory.getOfficerMasterDao().findById(officerMaster.getOfficerId()).get();
        existOfficer.setName(officerMaster.getName());
        if (officerMaster.getPassword() != null && officerMaster.getPassword().length() > 0) {
            existOfficer.setPassword(passwordEncoder.encode(officerMaster.getPassword()));
        }
        existOfficer.setOfficerType(officerMaster.getOfficerType());
        existOfficer.setPhoneNo(officerMaster.getPhoneNo());
        existOfficer.setModifiedDate(Instant.now());
        return daoFactory.getOfficerMasterDao().modifyOfficer(existOfficer);
    }


    @Override
    public OfficerMaster findByUserName(String userName) {
        return null;
    }

    @Override
    public OfficerMaster findByemail(String email) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public Optional<OfficerMaster> findById(Long id) {
        return daoFactory.getOfficerMasterDao().findById(id);
    }
}
