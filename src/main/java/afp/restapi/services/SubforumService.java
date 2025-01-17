package afp.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import afp.restapi.models.Subforum;
import afp.restapi.repositories.SubforumRepo;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubforumService {

    private final SubforumRepo SUBFORUMREPO;

    public SubforumService(SubforumRepo SUBFORUMREPO){
        this.SUBFORUMREPO = SUBFORUMREPO;
    }

    public List<Subforum> getSubforums(){
        return SUBFORUMREPO.findAll();
    }

    public Optional<Subforum> getSubforum(Long id){
        return SUBFORUMREPO.findById(id);
    }

    public Subforum saveSubforum(Subforum subforum){
        return SUBFORUMREPO.save(subforum);
    }

    public List<Subforum> saveSubforums(List<Subforum> subForums){
        return SUBFORUMREPO.saveAll(subForums);
    }
    
    public Subforum updateSubforum(Subforum subForum){
        return SUBFORUMREPO.save(subForum);
    }

    public void deleteSubforum(Long id){
        SUBFORUMREPO.deleteById(id);
    }
}
