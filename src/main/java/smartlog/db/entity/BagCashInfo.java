package smartlog.db.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tbl_bag_cash_info")
public class BagCashInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bagId;

    @Column(name = "bagType")
    private String bagType;

    @Column(name = "locationPhotoUrl")
    private String locationPhotoUrl;

    @Column(name = "oneDollarCount")
    private Integer oneDollarCount;

    @Column(name = "fiveDollarCount")
    private Integer fiveDollarCount;

    @Column(name = "tenDollarCount")
    private Integer tenDollarCount;

    @Column(name = "fiftyDollarCount")
    private Integer fiftyDollarCount;

    @Column(name = "hundredDollarCount")
    private Integer hundredDollarCount;

    @Column(name = "thousandDollarCount")
    private Integer thousandDollarCount;

    @Column(name = "totalAmount")
    private Integer totalAmount;

    @Column(name = "createdDate")
    private Instant createdDate;

    @Column(name = "modifiedDate")
    private Instant modifiedDate;


    public Long getBagId() {
        return bagId;
    }

    public void setBagId(Long bagId) {
        this.bagId = bagId;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getLocationPhotoUrl() {
        return locationPhotoUrl;
    }

    public void setLocationPhotoUrl(String locationPhotoUrl) {
        this.locationPhotoUrl = locationPhotoUrl;
    }

    public Integer getOneDollarCount() {
        return oneDollarCount;
    }

    public void setOneDollarCount(Integer oneDollarCount) {
        this.oneDollarCount = oneDollarCount;
    }

    public Integer getFiveDollarCount() {
        return fiveDollarCount;
    }

    public void setFiveDollarCount(Integer fiveDollarCount) {
        this.fiveDollarCount = fiveDollarCount;
    }

    public Integer getTenDollarCount() {
        return tenDollarCount;
    }

    public void setTenDollarCount(Integer tenDollarCount) {
        this.tenDollarCount = tenDollarCount;
    }

    public Integer getFiftyDollarCount() {
        return fiftyDollarCount;
    }

    public void setFiftyDollarCount(Integer fiftyDollarCount) {
        this.fiftyDollarCount = fiftyDollarCount;
    }

    public Integer getHundredDollarCount() {
        return hundredDollarCount;
    }

    public void setHundredDollarCount(Integer hundredDollarCount) {
        this.hundredDollarCount = hundredDollarCount;
    }

    public Integer getThousandDollarCount() {
        return thousandDollarCount;
    }

    public void setThousandDollarCount(Integer thousandDollarCount) {
        this.thousandDollarCount = thousandDollarCount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

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

}
