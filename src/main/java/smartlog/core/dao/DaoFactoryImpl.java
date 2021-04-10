package smartlog.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartlog.atm.dao.AtmDao;
import smartlog.officer.dao.OfficerMasterDao;

@Service
public class DaoFactoryImpl implements DaoFactory {

    @Autowired
    private OfficerMasterDao officerMasterDao;

    @Autowired
    private AtmDao atmDao;

    @Override
    public OfficerMasterDao getOfficerMasterDao() {
        return officerMasterDao;
    }

    @Override
    public AtmDao getAtmDao() {
        return atmDao;
    }
}
