package afp.restapi.models;

import java.time.LocalDate;
import java.util.Collection;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    @Column(unique=true)
    private String email;
    private String password;
    private LocalDate date;
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    Collection<Roles> role;

    public Users(){};
    public Users(Long userId,String userName, String email, String password,
     LocalDate date, Collection<Roles> role){
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.date = date;
        this.role = role;
    };

    public Long getUserId(){
        return this.userId;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public Collection<Roles> getRole(){
        return this.role;
    }

    public void setRole(Collection<Roles> role){
        this.role = role;
    }
}
