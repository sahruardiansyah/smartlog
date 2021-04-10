package smartlog.officer.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreateOfficerRequest {
    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, message = "Password must have be at least 6 characters")
    private String password;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Phone number must not be blank")
    private String phoneNo;

    @NotBlank(message = "Officer type must not be blank")
    private String officerType;

    Long roleId ;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

}
