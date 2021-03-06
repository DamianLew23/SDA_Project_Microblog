package sda.project.microblog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private long id;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(unique = true)
    private String userName;
    @OneToMany(mappedBy = "user")
    private List<Post>postList = new ArrayList<>();




    public User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
    }

    public User() {

    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
