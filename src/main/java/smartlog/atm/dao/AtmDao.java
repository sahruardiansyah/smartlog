package smartlog.atm.dao;

import smartlog.db.entity.AtmMaster;

import java.util.NoSuchElementException;

public interface AtmDao {
    public AtmMaster createAtm(AtmMaster atmMaster);
    public AtmMaster modifyAtm(AtmMaster atmMaster) throws NoSuchElementException;
}
