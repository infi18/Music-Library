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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author siddhi
 */
@Entity
@NamedQuery(name = "Album.findAll", query = "select a from Album a")
@NamedQuery(name = "Album.findById", query = "select a from Album a where a.id = :id")
@NamedQuery(name = "Album.findByName", query = "select a from Album a where a.albumName = :albumName")
public class Album extends AbstractEntity {

    //Inverse side of bidirectional one to many reltionship with songs
    @OneToMany( cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Songs> Songs = new ArrayList<Songs>();

    //Owning side of bidirectional many to many reltionship with singer
    @ManyToMany(cascade = { CascadeType.ALL}, fetch=FetchType.EAGER)
    private List<Singer> Singer = new ArrayList<>();
    
    
    @NotBlank(message = "Album Name cannot be blank !")
    private String albumName;
    
    private LocalDate Release_Date;
    
    private int Total_Songs;
    
    @Transient
    private String song_names;
    
    @Transient
    private String singer_names;
    /**
     *
     */
    public Album() {
    }

    /**
     *Constructors Initialized
     * @param albumName
     */
    public Album(String albumName) {
        this.albumName = albumName;
    }

    /**
     *Constructors Initialized
     * @param Album_Name
     * @param Release_Date
     */
    public Album(String albumName, LocalDate Release_Date) {
        this.albumName = albumName;
        this.Release_Date = Release_Date;
    }

    /**
     *Constructors Initialized
     * @param Album_Name
     * @param Release_Date
     * @param Total_Songs
     */
    public Album(String albumName, LocalDate Release_Date, int Total_Songs) {
        this.albumName = albumName;
        this.Release_Date = Release_Date;
        this.Total_Songs = Total_Songs;
    }
         

    /**
     *removes singer associated with album
     * @param s
     */
    public void addSinger(Singer s) {
        if (!this.Singer.contains(s)) {
            this.Singer.add(s);
        }
        if (!s.getAlbum().contains(this)) {
            s.getAlbum().add(this);
        }
    }

    /**
     *removes singer associated with album
     * @param s
     */
    public void removeSinger(Singer s) {
        if (this.Singer.contains(s)) {
            this.Singer.remove(s);
        }
        if (s.getAlbum().contains(this)) {
            s.getAlbum().remove(this);
        }
    }

    //Getters and Setters
    /**
     * Get the value of albumName
     *
     * @return the value of albumName
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * Set the value of albumName
     *
     * @param albumName new value of albumName
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * Get the value of Release_Date
     *
     * @return the value of Release_Date
     */
    public LocalDate getRelease_Date() {
        return Release_Date;
    }

    /**
     * Set the value of Release_Date
     *
     * @param Release_Date new value of Release_Date
     */
    public void setRelease_Date(LocalDate Release_Date) {
        this.Release_Date = Release_Date;
    }

    /**
     * Get the value of Total_Songs
     *
     * @return the value of Total_Songs
     */
    public int getTotal_Songs() {
        return Total_Songs;
    }

    /**
     * Set the value of Total_Songs
     *
     * @param Total_Songs new value of Total_Songs
     */
    public void setTotal_Songs(int Total_Songs) {
        this.Total_Songs = Total_Songs;
    }

    /**
     * Get the value of Singer
     *
     * @return the value of Singer
     */
    public List<Singer> getSinger() {
        return Singer;
    }

    /**
     *
     * @param Singer
     */
    public void setSinger(List<Singer> Singer) {
        this.Singer = Singer;
    }
    
    /**
     *
     * @return
     */
    public List<Songs> getSongs() {
        return Songs;
    }

    /**
     *
     * @param Songs
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
    public String getSinger_names() {
        return singer_names;
    }

    /**
     *
     * @param singer_names
     */
    public void setSinger_names(String singer_names) {
        this.singer_names = singer_names;
    }
    
    
    //To String Method for printing values
    @Override
    public String toString() {
        return "Album{" + "Songs=" + Songs + ", Singer=" + Singer + ", Album_Name=" + albumName + ", Release_Date=" + Release_Date + ", Total_Songs=" + Total_Songs + '}';
    }
    
    
    

}
