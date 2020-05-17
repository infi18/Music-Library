/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author siddhi
 */
@Entity
@Table(name = "Security_User")
@EntityListeners(UserListener.class)
@NamedQuery(name = "Users.findAll", query = "select us from User us")
public class User {

    @Id
    @NotBlank(message = "Please enter a username")
    private String username;

    @NotBlank(message = "Only the worthy can enter !! (with a password)")
    private String password;

    private Boolean Flag;

    @ManyToMany
    @JoinTable(name = "Security_User_Groups",
            joinColumns = @JoinColumn(name = "Username"),
            inverseJoinColumns = @JoinColumn(name = "GroupName"))
    private List<Group> groups = new ArrayList<>();

    //Adding the Helper Methods

    /**
     *Adds group to user
     * @param g
     */
    public void AddGroup(Group g) {
        if (!(this.groups.contains(g))) {
            this.groups.add(g);
        }
        if (!(g.getUsers().contains(this))) {
            g.getUsers().add(this);
        }
    }

    /**
     *Constructors Initialized
     */
    public User() {
    }

    /**
     *Constructors Initialized
     * @param string
     * @param string1
     * @param bln
     */
    public User(String Username, String Password, Boolean Flag) {
        this.username = Username;
        this.password = Password;
        this.Flag = Flag;
    }
    
    //Getters and Setters
    /**
     * Get the value of groups
     *
     * @return the value of groups
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Set the value of groups
     *
     * @param groups new value of groups
     */
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /**
     * Get the value of Flag
     *
     * @return the value of Flag
     */
    public Boolean isFlag() {
        return Flag;
    }

    /**
     * Set the value of Flag
     *
     * @param Flag new value of Flag
     */
    public void setFlag(Boolean Flag) {
        this.Flag = Flag;
    }

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.password = Password;
    }

    /**
     * Get the value of Username
     *
     * @return the value of Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of Username
     *
     * @param Username new value of Username
     */
    public void setUsername(String Username) {
        this.username = Username;
    }

    //To String Method for printing values
    @Override
    public String toString() {
        return "User{" + "Username=" + username + ", Flag=" + Flag + '}';
    }
    
    
}
