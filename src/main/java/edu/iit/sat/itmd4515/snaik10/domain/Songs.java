/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author siddhi
 */
@Entity
@NamedQuery(name = "Songs.findAll", query = "select sg from Songs sg")
@NamedQuery(name = "Songs.findById", query = "select sg from Songs sg where sg.id = :id")
@NamedQuery(name = "Songs.findByCode", query = "select sg from Songs sg where sg.songCode = :songCode")
@NamedQuery(name = "Songs.findByName", query = "select sg from Songs sg where sg.songName = :songName")
public class Songs extends AbstractEntity {

    //Owning side of bidirectional many to one reltionship with singer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_id")
    private Singer singer;

//    //Owning side of bidirectional many to one reltionship with album
//    @ManyToOne
//    @JoinTable
//    private Album album;

    @NotBlank(message = "Song's Name Cannot be Blank !! Please Enter the Song's Name")
    @Column(nullable = false)
    private String songName;

    @NotBlank(message = "Song's Code Cannot be Blank and has to be Unique !! Please Enter a Unique Code")
    @Column(unique = true, nullable = false)
    private String songCode;

    @NotBlank(message = "Singer's Name Cannot be Blank !! Please Enter the Singer's Name")
    private String songSingerName;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    //Constructor Initialization
    /**
     *
     */
    public Songs() {
    }

    /**
     *
     * @param songName
     * @param songCode
     */
    public Songs(String songName, String songCode) {
        this.songName = songName;
        this.songCode = songCode;
    }

    /**
     *
     * @param songName
     * @param songCode
     * @param songSingerName
     * @param genre
     */
    public Songs(String songName, String songCode, String songSingerName, Genre genre) {
        this.songName = songName;
        this.songCode = songCode;
        this.songSingerName = songSingerName;
        this.genre = genre;
    }

    //Getters and Setters
    /**
     * Get the value of songName
     *
     * @return the value of songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * Set the value of songName
     *
     * @param songName new value of songName
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * Get the value of songCode
     *
     * @return the value of songCode
     */
    public String getSongCode() {
        return songCode;
    }

    /**
     * Set the value of songCode
     *
     * @param songCode new value of songCode
     */
    public void setSongCode(String songCode) {
        this.songCode = songCode;
    }

    /**
     * Get the value of genre
     *
     * @return the value of genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Set the value of genre
     *
     * @param genre new value of genre
     */
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    /**
     * Get the value of songSingerName
     *
     * @return the value of songSingerName
     */
    public String getSongSingerName() {
        return songSingerName;
    }

    /**
     * Set the value of songSingerName
     *
     * @param songSingerName new value of songSingerName
     */
    public void setSongSingerName(String songSingerName) {
        this.songSingerName = songSingerName;
    }

    /**
     * Get the value of singer
     *
     * @return the value of singer
     */
    public Singer getSinger() {
        return singer;
    }

    /**
     * Set the value of singer
     *
     * @param singer new value of singer
     */
    public void setSinger(Singer singer) {
        this.singer = singer;

        if (!singer.getSongs().contains(this)) {
            singer.getSongs().add(this);
        }
    }

    /**
     *
     * @return
     */
//    public Album getAlbum() {
//        return album;
//    }
//
//    /**
//     *
//     * @param album
//     */
//    public void setAlbum(Album album) {
//        this.album = album;
//        if (!album.getSongs().contains(this)) {
//            album.getSongs().add(this);
//        }
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.songCode);
        return hash;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        final Songs other = (Songs) that;
        if (!Objects.equals(this.songCode, other.songCode)) {
            return false;
        }
        return true;
    }

    //To String Method for printing values
    @Override
    public String toString() {
        return "Songs{" + "id=" + id + ", songName=" + songName + ", songCode=" + songCode + ", Singer=" + songSingerName + ", genre=" + genre + '}';
    }

}
