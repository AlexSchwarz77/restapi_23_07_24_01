package afp.restapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;

    public Roles(){};
    public Roles(Long roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    };

    public Long getRoleId(){
        return this.roleId;
    }

    public String getRoleName(){
        return this.roleName;
    }

    public void setRoleName(String roleName){
        this.roleName = roleName;
    }
}
