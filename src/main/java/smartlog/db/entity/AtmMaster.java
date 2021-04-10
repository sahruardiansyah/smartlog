package smartlog.db.entity;

import smartlog.atm.entity.CreateAtmRequest;
import smartlog.atm.entity.ModifyAtmRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_atm_master")
public class AtmMaster implements Serializable {

//    @EmbeddedId
//    private AtmBagCompKey atmId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long atmId;

    @Column(name="location")
    private String location;

    public AtmMaster(){

    }
    public AtmMaster(CreateAtmRequest request){
        this.location = request.getLocation();

    }
    public AtmMaster(Long id, ModifyAtmRequest request){
        this.atmId = id;
        this.location = request.getLocation();

    }

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtmMaster)) return false;
        AtmMaster that = (AtmMaster) o;
        return Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }

    @Override
    public String toString() {
        return "AtmMaster{" +
//                "atmId=" + atmId +
                ", location='" + location + '\'' +
                '}';
    }
}
