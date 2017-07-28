package org.academiadecodigo.bootcamp.model;

/**
 * Created by codecadet on 28/07/2017.
 */
public class Preferences {

    private Integer id;
    private Integer userID;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
