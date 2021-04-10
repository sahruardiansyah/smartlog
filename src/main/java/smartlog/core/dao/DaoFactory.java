package smartlog.core.dao;

import smartlog.atm.dao.AtmDao;
import smartlog.officer.dao.OfficerMasterDao;

public interface DaoFactory {

    OfficerMasterDao getOfficerMasterDao();
    AtmDao getAtmDao();
}
