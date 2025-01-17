package afp.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import afp.restapi.models.Subforum;

@Repository
public interface SubforumRepo extends JpaRepository<Subforum, Long> {
    
}
