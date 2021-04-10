package smartlog.db.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "tbl_atm_bag")
@IdClass(AtmBagCompKey.class)
public class AtmBag implements Serializable {
    @Id
    @OneToOne
//    @Column(name = "atmId")
    private AtmMaster atmId;

    @Id
    @ManyToOne
//    @Column(name = "bagId")
    private BagCashInfo bagId;

    @Column(name="createDate")
    private Instant createdDate;

    @Column(name="collectDate")
    private Instant modifiedDate;


    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AtmMaster getAtmId() {
        return atmId;
    }

    public void setAtmId(AtmMaster atmId) {
        this.atmId = atmId;
    }

    public BagCashInfo getBagId() {
        return bagId;
    }

    public void setBagId(BagCashInfo bagId) {
        this.bagId = bagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtmBag)) return false;
        AtmBag atmBag = (AtmBag) o;
        return getAtmId().equals(atmBag.getAtmId()) &&
                getBagId().equals(atmBag.getBagId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAtmId(), getBagId());
    }

    @Override
    public String toString() {
        return "AtmBag{" +
//                "atmId=" + atmId +
//                ", bagId=" + bagId +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
