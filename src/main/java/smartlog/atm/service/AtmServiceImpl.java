package smartlog.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartlog.atm.service.AtmService;
import smartlog.core.dao.DaoFactory;
import smartlog.db.entity.AtmMaster;
import smartlog.db.repository.AtmRepository;

import java.util.NoSuchElementException;

@Service
public class AtmServiceImpl implements AtmService {
    @Autowired
    DaoFactory daoFactory;
    @Autowired
    AtmRepository repository;
    @Override
    public AtmMaster processCreateAtm(AtmMaster atmMaster) {
        return daoFactory.getAtmDao().createAtm(atmMaster);
    }

    @Override
    public AtmMaster processModifyAtm(AtmMaster atmMaster) throws NoSuchElementException {
        AtmMaster exist = repository.findById(atmMaster.getAtmId()).get();
        exist.setLocation(atmMaster.getLocation());
        return daoFactory.getAtmDao().modifyAtm(exist);
    }
}
