/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author siddhi
 */
@Entity
@Table(name = "Security_Group")
@NamedQuery(name = "Group.findAll", query = "select gp from Group gp")
public class Group {

    @Id
    private String GroupName;

    private String Description;

    @ManyToMany(mappedBy = "groups")
    private List<User> Users = new ArrayList<>();

    /**
     *Constructors Initialized
     */
    public Group() {
    }

    /**
     *Constructors Initialized
     * @param string
     * @param string1
     */
    public Group(String GroupName, String Description) {
        this.GroupName = GroupName;
        this.Description = Description;
    }

    //Getters and Setters
    /**
     * Get the value of GroupName
     *
     * @return the value of GroupName
     */
    public String getGroupName() {
        return GroupName;
    }

    /**
     * Set the value of GroupName
     *
     * @param GroupName new value of GroupName
     */
    public void setGroupName(String GroupName) {
        this.GroupName = GroupName;
    }

    /**
     * Get the value of Description
     *
     * @return the value of Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * Set the value of Description
     *
     * @param Description new value of Description
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }

    /**
     * Get the value of Users
     *
     * @return the value of Users
     */
    public List<User> getUsers() {
        return Users;
    }

    /**
     * Set the value of Users
     *
     * @param Users new value of Users
     */
    public void setUsers(List<User> Users) {
        this.Users = Users;
    }

    //To String Method for printing values
    @Override
    public String toString() {
        return "Group{" + "GroupName=" + GroupName + '}';
    }

    
}
