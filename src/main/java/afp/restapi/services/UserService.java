package afp.restapi.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import afp.restapi.models.IUsers;
import afp.restapi.models.Roles;
import afp.restapi.models.Users;
import afp.restapi.repositories.UserRepo;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Version;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    
    private final UserRepo USERREPO;
    private final BCrypt.Hasher HASHALG = BCrypt.with(Version.VERSION_2Y);

    private List<String> sessionList = new ArrayList<>();

    public UserService(UserRepo USERREPO){
        this.USERREPO = USERREPO;
    }

    public List<Users> findAllUsers(){
        return USERREPO.findAll();
    }

    public Users saveUser(Users user){
        user.setPassword(HASHALG.hashToString(6, user.getPassword().toCharArray()));
        return USERREPO.save(user);
    }

    public Optional<Users> findUserById(Long id){
        return USERREPO.findById(id);
    }

    public Users updateUser(Users user){
        Optional<Users> userDB = USERREPO.findById(user.getUserId());
        user.setPassword(userDB.get().getPassword());
        return USERREPO.save(user);
    }

    public String updatePassword(Long userID, String passwordOld, String passwordNew){
        Optional<Users> userDb = USERREPO.findById(userID);

        if(!userDb.isEmpty()){
            if (BCrypt.verifyer().verify(passwordOld.toCharArray(), userDb.get().getPassword()).verified) {                USERREPO.updatePassword(HASHALG.hashToString(6, passwordNew.toCharArray()), userID);
                return "Your new Password is sets";
            }else{
                return "Your password is incorrect";
            }
        }
        return "Error (╯°□°）╯︵ ┻━┻";
    }

    public void deleteUser(Users user){
        USERREPO.delete(user);
    }

    public Optional<List<Users>> findUserByDate(LocalDate date){
        return USERREPO.findUsersByDate(date);
    }

    public Optional<Users> findUserByIdAndEmail(Long id, String email){
        return USERREPO.findUserByIdAndEMail(id, email);
    }

    public List<Users> getUserByRole(String role){
        List<Users> filteredList = new ArrayList<>();
        List<Users> list = USERREPO.findAll();

        for(Users u : list){
            for(Roles r: u.getRole()){
                if (r.getRoleName().equals(role)) {
                    filteredList.add(u);
                }
            }
        }
        return filteredList;
    }

    public Boolean logIn(String password, String email, HttpServletRequest request){
        
        sessionList = (List<String>) request.getSession().getAttribute("USER_SESSION");
        Optional<Users> userDb = USERREPO.logIn(email);

        if(userDb.isEmpty() == true){
            return null;
        }
        
        if(BCrypt.verifyer().verify(password.toCharArray(), userDb.get().getPassword()).verified){
            if (sessionList == null) {
                sessionList = new ArrayList<>();
                request.getSession().setAttribute("USER_SESSION", sessionList);
            }
            if (!sessionList.contains(userDb.get().getEmail())) {
                sessionList.add(userDb.get().getEmail());
            }
            
            request.getSession().setAttribute("USER_SESSION", sessionList);
            System.out.println(request.getSession().getAttribute("USER_SESSION"));
            return true;
        }
        return false;
    }

    public IUsers getIUserByEmail(String email){
        System.out.println(email);
        return USERREPO.getIUser(email);
    }
}
