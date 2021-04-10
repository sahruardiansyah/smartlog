package smartlog.atm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartlog.db.entity.AtmMaster;
import smartlog.db.repository.AtmRepository;

import java.util.NoSuchElementException;

@Service
public class AtmDaoImpl implements AtmDao {

    @Autowired
    AtmRepository repository;
    @Override
    public AtmMaster createAtm(AtmMaster atmMaster) {
        return repository.save(atmMaster);
    }

    @Override
    public AtmMaster modifyAtm(AtmMaster atmMaster) throws NoSuchElementException {
        if (atmMaster.getAtmId() == null){
            throw new NoSuchElementException();
        }else {
            return repository.save(atmMaster);
        }
    }
}
