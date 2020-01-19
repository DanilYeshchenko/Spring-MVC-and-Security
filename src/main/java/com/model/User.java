package com.model;

//import com.DAO.UserDAO;
//import org.hibernate.Session;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 18.06.2017.
 */
@Entity
public class User {
//    UserDAO userDao;
//    public void setUserDao(UserDAO userDao) {
//        this.userDao = userDao;
//    }

    private String username;
    private String password;
    private boolean enabled;
    private Set<UserRoles> userRole = new HashSet<UserRoles>(0);
//    public Set<UserRoles> getUserRole() {
//        return userRole;
//    }
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
//    public void setUserRole(Set<UserRoles> userRole) {
//        this.userRole = userRole;
//    }

    @Id
    @Column(name = "username", nullable = false, length = 11)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 11)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled", nullable = false)
    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public User(String username, String password, boolean enabled, Set<UserRoles> userRole) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }
//    public User findByOut(String username, String password){
//        return userDao.findByOuf(username, password);
//    }
}
