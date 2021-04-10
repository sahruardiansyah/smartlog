package smartlog.db.entity;

import java.io.Serializable;
import java.util.Objects;


public class AtmBagCompKey implements Serializable {

    private long atmId;

    private long bagId;

    public long getAtmId() {
        return atmId;
    }

    public void setAtmId(long atmId) {
        this.atmId = atmId;
    }

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtmBagCompKey)) return false;
        AtmBagCompKey that = (AtmBagCompKey) o;
        return getAtmId() == that.getAtmId() &&
                getBagId() == that.getBagId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAtmId(), getBagId());
    }
}
