package smartlog.db.entity;


import smartlog.officer.entity.CreateOfficerRequest;
import smartlog.officer.entity.ModifyOfficerRequest;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tbl_officer_master")

public class OfficerMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="officerId")
    private Long officerId;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="phoneNo")
    private String phoneNo;

    @Column(name="officerType")
    private String officerType;

    @Column(name="createdDate")
    private Instant createdDate;

    @Column(name="modifiedDate")
    private Instant modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public OfficerMaster(){

    }
    public OfficerMaster(CreateOfficerRequest request){
        this.name = request.getName();
        this.email = request.getEmail();
        this.phoneNo = request.getPhoneNo();
        this.password = request.getPassword();
        this.officerType = request.getOfficerType();
        Role role = new Role(request.getRoleId());
        this.role = role;


    }
    public OfficerMaster(Long id, ModifyOfficerRequest request){
        this.officerId = id;
        this.name = request.getName();
        this.phoneNo = request.getPhoneNo();
        this.email = request.getEmail();
        this.password = request.getPassword();
        this.officerType =request.getOfficerType();
        Role role = new Role(request.getRoleId());
        this.role = role;

    }

    public Long getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Long officerId) {
        this.officerId = officerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getOfficerType() {
        return officerType;
    }

    public void setOfficerType(String officerType) {
        this.officerType = officerType;
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

    @Override
    public String toString() {
        return "OfficerMaster{" +
                "officerId=" + officerId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", officerType='" + officerType + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", role=" + role +
                '}';
    }
}
