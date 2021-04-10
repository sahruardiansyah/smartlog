package smartlog.authenticate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import smartlog.db.entity.OfficerMaster;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * Implementation of UserDetails which will be used by Spring Boot Security framework as user data model
 * 
 * @author Tom
 *
 */
public class UserPrincipal implements UserDetails {
	

	private Long id;

    private String name;

    private String email;

    private String password;
    private String phoneNo;
    private String officerType;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String name, String email, String password,String phoneNo, String officerType, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.phoneNo = phoneNo;
        this.officerType = officerType;

    }
    public static UserPrincipal create(OfficerMaster user) {

        // The authorities are associated to privileges granted to the role that assigned to user.
        List<GrantedAuthority> authorities = user.getRole().getPrivileges().stream().map(privlige ->
                new SimpleGrantedAuthority(privlige.getPrivilegeCode())
        ).collect(Collectors.toList());

//        logger.info("UserPrincipal id {}, authorities {}", user.getOfficerId(), authorities);

        return new UserPrincipal(
                user.getOfficerId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNo(),
                user.getOfficerType(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
