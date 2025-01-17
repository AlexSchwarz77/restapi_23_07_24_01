package afp.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import afp.restapi.models.Thread;

public interface ThreadRepo extends JpaRepository<Thread, Long>{
    
}
