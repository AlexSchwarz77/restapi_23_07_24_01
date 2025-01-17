package afp.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import afp.restapi.models.Roles;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Long>{
    
}
