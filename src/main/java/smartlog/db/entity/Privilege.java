package smartlog.db.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "tbl_privilege", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "id"
        })
})
public class Privilege  {

	/**
	 * 
	 */

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	Long id;
	
    @NotBlank(message = "Privilege name must not be blank")
    @Column(name="privilege_name")
	private String privilegeName;
	
    @NotBlank(message = "Privilege code must not be blank")
    @Column(name="privilege_code")
	private String privilegeCode;
	
    @Column(name="privilege_description")
	private String privilegeDescription;
	
	public Privilege() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}
	
	public String getPrivilegeDescription() {
		return this.privilegeDescription;
	}
	
	public void setPrivilegeDescription(String privilegeDescription) {
		this.privilegeDescription = privilegeDescription;
	}

	public String getPrivilegeCode() {
		return privilegeCode;
	}

	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}

}
