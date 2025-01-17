package afp.restapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long threadId;
    private String threadTitle;
    @ManyToOne
    @JoinColumn(name = "subForumId")
    private Subforum subForum;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;
    @Lob
    private String content;

    public Thread(){}
    public Thread(Long threadId, String threadTitle, Subforum subForum, Users user, String content){
        this.threadId = threadId;
        this.threadTitle = threadTitle;
        this.subForum = subForum;
        this.user = user;
        this.content = content;
    }

    public Long getThreadId(){
        return this.threadId;
    }

    public String getThreadTitle(){
        return this.threadTitle;
    }
    public void setThreadTitle(String threadTitle){
        this.threadTitle = threadTitle;
    }

    public Subforum getSubForum(){
        return this.subForum;
    }

    public void setSubForum(Subforum subForum){
        this.subForum = subForum;
    }

    public Users getUser(){
        return this.user;
    }

    public void setUser(Users user){
        this.user = user;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

}
