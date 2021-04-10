package smartlog.atm.service;

import smartlog.db.entity.AtmMaster;

import java.util.NoSuchElementException;

public interface AtmService {
    public AtmMaster processCreateAtm(AtmMaster atmMaster);
    public AtmMaster processModifyAtm(AtmMaster atmMaster) throws NoSuchElementException;
}
