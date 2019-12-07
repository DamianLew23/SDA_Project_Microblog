package sda.project.microblog.model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private long id;

    private String login;
    private String passoword;
    private String userName;

    public User(long id, String login, String passoword, String userName) {
        this.id = id;
        this.login = login;
        this.passoword = passoword;
        this.userName = userName;
    }

    public User(){

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassoword() {
        return passoword;
    }

    public void setPassoword(String passoword) {
        this.passoword = passoword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
