package afp.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afp.restapi.models.Thread;
import afp.restapi.services.ThreadService;

@RestController
@RequestMapping(value = "/v1")
public class ThreadController {
    
    private final ThreadService THREADSERVICE;

    public ThreadController(ThreadService THREADSERVICE){
        this.THREADSERVICE = THREADSERVICE;
    }

    @GetMapping(value = "/thread/findAll")
    private ResponseEntity<List<Thread>> findThreads(){
        return new ResponseEntity<>(THREADSERVICE.findThreads(), HttpStatus.OK);
    }

    @GetMapping(value = "/thread/{id}")
    private ResponseEntity<Optional<Thread>> findThread(@PathVariable("id") Long id){
        return new ResponseEntity<>(THREADSERVICE.findThreadById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/thread")
    private ResponseEntity<Thread> saveThread(@RequestBody Thread thread){
        return new ResponseEntity<>(THREADSERVICE.saveThread(thread), HttpStatus.CREATED);
    }

    @PostMapping(value = "/thread/all")
    private ResponseEntity<List<Thread>> saveThreads(@RequestBody List<Thread> threads){
        return new ResponseEntity<>(THREADSERVICE.saveThreads(threads), HttpStatus.CREATED);
    }

    @PutMapping(value = "thread/update")
    private ResponseEntity<Thread> updateThread(@RequestBody Thread thread){
        return new ResponseEntity<>(THREADSERVICE.updateThread(thread), HttpStatus.OK);
    }

    @DeleteMapping(value = "thread/{id}")
    private void deleteThread(@PathVariable("id") Long id){
        THREADSERVICE.deleteThread(id);
    }
}
