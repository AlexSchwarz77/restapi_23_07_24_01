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

import afp.restapi.models.Roles;
import afp.restapi.services.RoleService;

@RequestMapping(path = "/v1")
@RestController
public class RoleController {
    private final RoleService ROLESERVICE;

    public RoleController(RoleService ROLESERVICE){
        this.ROLESERVICE = ROLESERVICE;
    }

     @GetMapping(path = "/role/findAll")
    private ResponseEntity<List<Roles>> findAllroles(){
        return new ResponseEntity<>(ROLESERVICE.findAllRoles(), HttpStatus.OK);
    }

    @PostMapping(path = "/role")
    private ResponseEntity<Roles> saveRole(@RequestBody Roles role){
        return new ResponseEntity<Roles>(ROLESERVICE.saveRole(role), HttpStatus.CREATED);
    }

    @GetMapping(path = "/role/{id}")
    private ResponseEntity<Optional<Roles>> findRoleById(@PathVariable("id") Long id){
        return new ResponseEntity<Optional<Roles>>(ROLESERVICE.findRoleById(id), HttpStatus.OK);
    }

    @PutMapping(path = "/role")
    private ResponseEntity<?> updateRole(@RequestBody Roles role){
        return new ResponseEntity<>
        (ROLESERVICE.updateRole(role), HttpStatus.OK);
    }

    @DeleteMapping(path = "/role/delete")
    private ResponseEntity<?> deleterole(@RequestBody Roles role){
        ROLESERVICE.deleteRole(role);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
