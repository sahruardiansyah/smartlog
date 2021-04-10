package smartlog.db.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_role", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "id", 
//            "role_title"
        })
})
@JsonSerialize(using=RoleJsonSerializer.class)
public class Role {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6203149979795100062L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
	
    @NotBlank(message = "Role title must not be blank")
    @Column(name="role_title")
	private String roleTitle;
	
    @Column(name="role_description")
	private String roleDescription;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_role_privilege", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
	@JsonIgnore
	private Set<Privilege> privileges = new HashSet<>();

	public Role() {
		
	}
	
	public Role(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	
	public Set<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
}

