/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author siddhi
 */
@Entity

@NamedQuery(name = "Playlist.findAll", query = "select p from Playlist p")
@NamedQuery(name = "Playlist.findById", query = "select p from Playlist p where p.id = :id")
@NamedQuery(name = "Playlist.findByName", query = "select p from Playlist p where p.Name = :Name")
public class Playlist extends AbstractEntity {

    //Owning side of bidirectional many to one reltionship with Listener
    @ManyToOne
    private Listener listener;

    //Unidirectional one to many reltionship with songs
    @OneToMany(cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
    @JoinTable
    private List<Songs> songs;

    private String Name;
    private int Number_of_Songs;
    
    
    @Transient
    private String song_names;
    
    /**
     *Constructor Initialization
     */
    public Playlist() {
    }

    /**
     *
     * @param string
     * @param i
     * @param bln
     */
    public Playlist(String Name, int Number_of_Songs) {
        this.Name = Name;
        this.Number_of_Songs = Number_of_Songs;
        

    }

    //Getters and Setters
    /**
     * Get the value of Name
     *
     * @return the value of Name
     */
    public String getName() {
        return Name;
    }

    /**
     * Set the value of Name
     *
     * @param Name new value of Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }


    /**
     * Get the value of Number_of_Songs
     *
     * @return the value of Number_of_Songs
     */
    public int getNumber_of_Songs() {
        return Number_of_Songs;
    }

    /**
     * Set the value of Number_of_Songs
     *
     * @param Number_of_Songs new value of Number_of_Songs
     */
    public void setNumber_of_Songs(int Number_of_Songs) {
        this.Number_of_Songs = Number_of_Songs;
    }

    /**
     *
     * @return songs
     */
    public List<Songs> getSongs() {
        return songs;
    }

    /**
     *
     * @param songs
     */
    public void setSongs(List<Songs> songs) {
        this.songs = songs;

    }

    /**
     * Get the value of listener
     *
     * @return the value of listener
     */
    public Listener getListener() {
        return listener;
    }

    /**
     * Set the value of listener
     *
     * @param listener new value of listener
     */
    public void setListener(Listener listener) {
        this.listener = listener;

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
        return "Playlist{" + "Name=" + Name + ", Number_of_Songs=" + Number_of_Songs + '}';
    }

}
