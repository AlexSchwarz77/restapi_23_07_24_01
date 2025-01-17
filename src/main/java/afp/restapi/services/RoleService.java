package afp.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import afp.restapi.models.Roles;
import afp.restapi.repositories.RoleRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoleService {
    private final RoleRepo ROLEREPO;

    public RoleService(RoleRepo ROLEREPO){
        this.ROLEREPO = ROLEREPO;
    }

    public List<Roles> findAllRoles(){
        return ROLEREPO.findAll();
    }

    public Roles saveRole(Roles role){
        return ROLEREPO.save(role);
    }

    public Optional<Roles> findRoleById(Long id){
        return ROLEREPO.findById(id);
    }

    public Roles updateRole(Roles role){
        return ROLEREPO.save(role);
    }

    public void deleteRole(Roles role){
        ROLEREPO.delete(role);
    }
}
