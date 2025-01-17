package afp.restapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Subforum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subForumId;
    @Column(unique = true)
    private String subForumName;

    public Subforum(){}
    public Subforum(Long subForumId, String subForumName){
        this.subForumId = subForumId;
        this.subForumName = subForumName;
    }

    public Long getSubForumId(){
        return this.subForumId;
    }

    public String getSubForumName(){
        return this.subForumName;
    }

    public void setSubForumName(String name){
        this.subForumName = name;
    }

}
