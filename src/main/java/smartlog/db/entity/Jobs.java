package smartlog.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tbl_jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="jobsId")
    private Long jobsId;

    @ManyToOne
    @JoinColumn(name = "officerId", nullable = false)
    private OfficerMaster officerId;


    @OneToOne
    @JoinColumns({@JoinColumn( name = "atmId", nullable = false),
    @JoinColumn(name = "bagId",nullable = false)})
    private AtmBag atmId;

    @Column(name="jobType")
    private String jobType;

    @Column(name="jobStatus")
    private String jobStatus;

    @Column(name="comment")
    private String comment;


    @Column(name="createdDate")
    private Instant createdDate;

    @Column(name="modifiedDate")
    private Instant modifiedDate;

    public Long getJobsId() {
        return jobsId;
    }

    public void setJobsId(Long jobsId) {
        this.jobsId = jobsId;
    }

    public OfficerMaster getOfficerId() {
        return officerId;
    }

    public void setOfficerId(OfficerMaster officerId) {
        this.officerId = officerId;
    }

    public AtmBag getAtmId() {
        return atmId;
    }

    public void setAtmId(AtmBag atmId) {
        this.atmId = atmId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "Jobs{" +
                "jobsId=" + jobsId +
                ", officerId=" + officerId +
                ", atmId=" + atmId +
                ", jobType='" + jobType + '\'' +
                ", jobStatus='" + jobStatus + '\'' +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
