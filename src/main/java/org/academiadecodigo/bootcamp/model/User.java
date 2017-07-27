package org.academiadecodigo.bootcamp.model;

import java.util.Set;

/**
 * Created by codecadet on 08/07/2017.
 */
public class User {

    private Integer id;
    private String password;
    private String email;
    private String username;
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password, String email) {
        this.password = password;
        this.email = email;
        this.username = username;
    }

    public User(Integer id, String username, String password, String email, Set roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
