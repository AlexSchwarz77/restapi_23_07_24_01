package afp.restapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import afp.restapi.repositories.ThreadRepo;
import jakarta.transaction.Transactional;

import afp.restapi.models.Thread;

@Service
@Transactional
public class ThreadService {

    private final ThreadRepo THREADREPO;

    public ThreadService(ThreadRepo THREADREPO){
        this.THREADREPO = THREADREPO;
    }

    public List<Thread> findThreads(){
        return THREADREPO.findAll();
    }

    public Optional<Thread> findThreadById(Long id){
        return THREADREPO.findById(id);
    }

    public Thread saveThread(Thread thread){
        return THREADREPO.save(thread);
    }

    public List<Thread> saveThreads(List<Thread> threads){
        return THREADREPO.saveAll(threads);
    } 

    public Thread updateThread(Thread thread){
        return THREADREPO.save(thread);
    }

    public void deleteThread(Long id){
        THREADREPO.deleteById(id);
    }
}
