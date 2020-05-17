/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

/**
 *
 * @author siddhi
 */
@Entity
@NamedQuery(name = "Singer.findAll", query = "select s from Singer s")
@NamedQuery(name = "Singer.findById", query = "select s from Singer s where s.id = :id")
@NamedQuery(name = "Singer.findByFirstName", query = "select s from Singer s where s.firstName = :firstName")
@NamedQuery(name = "Singer.findByLastName", query = "select s from Singer s where s.lastName = :lastName")
public class Singer extends Person {

    //Inverse side of bidirectional one to many reltionship with songs
    @OneToMany(mappedBy = "singer", cascade = {CascadeType.ALL})
    private List<Songs> Songs = new ArrayList<>();

    //Inverse side of bidirectional one to many reltionship with songs
    @ManyToMany(mappedBy = "Singer", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Album> Album = new ArrayList<>();

    @Transient
    private String song_names;
    
    @Transient
    private String album_names;

    //Constructor Initialization
    /**
     *
     */
    public Singer() {
    }

    /**
     *
     * @param First_Name
     * @param Last_Name
     * @param Email
     * @param DoB
     */
    public Singer(String First_Name, String Last_Name, String Email, LocalDate DoB) {
        super(First_Name, Last_Name, Email, DoB);
    }

    Singer(String tester, String one, LocalDate of) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Getters and Setters
    /**
     *
     * @return
     */
    public List<Album> getAlbum() {
        return Album;
    }

    /**
     *
     * @param Album
     */
    public void setAlbum(List<Album> Album) {
        this.Album = Album;
    }

    /**
     * Get the value of Songs
     *
     * @return the value of Songs
     */
    public List<Songs> getSongs() {
        return Songs;
    }

    /**
     * Set the value of Songs
     *
     * @param Songs new value of Songs
     */
    public void setSongs(List<Songs> Songs) {
        this.Songs = Songs;
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

    /**
     *
     * @return
     */
    public String getAlbum_names() {
        return album_names;
    }

    /**
     *
     * @param album_names
     */
    public void setAlbum_names(String album_names) {
        this.album_names = album_names;
    }
    
    //To String Method for printing values
    @Override
    public String toString() {
        return "Singer{" + "id=" + id + "," + "First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + emailId + ", DoB=" + DoB + '}';
    }
}
