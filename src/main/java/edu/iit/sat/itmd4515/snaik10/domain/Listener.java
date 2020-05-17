/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import edu.iit.sat.itmd4515.snaik10.security.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author siddhi
 */
@Entity
@NamedQuery(name = "Listener.findAll", query = "select l from Listener l")
@NamedQuery(name = "Listener.findById", query = "select l from Listener l where l.id = :id")
@NamedQuery(name = "Listener.findByFirstName", query = "select l from Listener l where l.firstName = :firstName")
@NamedQuery(name = "Listener.findByLastName", query = "select l from Listener l where l.lastName = :lastName")
@NamedQuery(name = "Listener.findByUsername", query = "select l from Listener l where l.User.username = :username")
public class Listener extends Person {


    @OneToOne
    @JoinColumn(name = "username")
    private User User;

    /**
     *
     */
    
    private long phoneNumber;
    
    
    @Transient
    private String song_names;

    /**
     *Initializing Constructor
     */
    public Listener() {
    }

    /**
     *
     * @param l
     * @param string
     * @param string1
     * @param ld
     * @param string2
     * @param DoB
     */
    public Listener(long phoneNumber, String First_Name, String Last_Name, String Email, LocalDate DoB) {
        super(First_Name, Last_Name, Email, DoB);
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the value of Playlist
     *
     * @return the value of Playlist
     */
    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public long getphoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the value of User
     *
     * @return the value of User
     */
    public User getUser() {
        return User;
    }

    /**
     * Set the value of User
     *
     * @param User new value of User
     */
    public void setUser(User User) {
        this.User = User;
    }

    /**
     *
     * @return
     */
    public String getSong_names() {
        return song_names;
    }

    /**
     *
     * @param song_names
     */
    public void setSong_names(String song_names) {
        this.song_names = song_names;
    }
    
    //To String Method for printing values
    @Override
    public String toString() {
        return "Listener{" + "id=" + id + ", " + "First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + emailId + ", Phone_Number=" + phoneNumber + ", DoB=" + DoB + '}';
    }
}
