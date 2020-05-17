/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.service.SongsService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author siddhi
 */
@Named
@RequestScoped
public class SongsController {

    private static final Logger LOG = Logger.getLogger(SongsController.class.getName());

    private Songs songs;

    @EJB
    SongsService SongsServ;

    /**
     * Constructor
     */
    public SongsController() {
    }

    /**
     * Post Construct Method
     */
    @PostConstruct
    public void postConstruct() {

        LOG.info("Inside the SongsController.postConstruct Method");
        songs = new Songs();
    }

    //Methods
    /**
     * adds songs to database
     *
     * @return
     */
    public String addSong() {

        LOG.info("Inside the addSongs method with:" + songs.toString());
        SongsServ.create(songs);
        return "/Listener/Confirmation.xhtml";
    }

    /**
     *adds songs to database via admin
     * @return
     */
    public String addSongs() {

        LOG.info("Inside the addSongs method with:" + songs.toString());
        SongsServ.create(songs);
        return "/Admin/confirmation.xhtml";
    }

    /**
     *updates songs
     * @return
     */
    public String updateSongs() {

        LOG.info("Inside the updateSongs method with:" + songs.toString());
        SongsServ.update(songs);
        return "/Admin/confirmation.xhtml";
    }

//           public String deleteSongs() {
//
//        LOG.info("Inside the updateSongs method with:" + songs.toString());
//        SongsServ.delete(songs);
//        return "/Admin/confirmation.xhtml";
//    }
    /**
     *Initializes the value of Songs by ID
     * Rather fetches songs my the ID selected
     */
    public void initSongsById() {
        LOG.info("listener Controller initlistenerById with " + this.songs.getId());
        this.songs = SongsServ.find(this.songs.getId());
        LOG.info("listener Controller initlistenerById after find " + this.songs.toString());
    }

    //Getters and Setters
    /**
     * Get the value of songs
     *
     * @return the value of songs
     */
    public Songs getSongs() {
        return songs;
    }

    /**
     * Set the value of songs
     *
     * @param songs new value of songs
     */
    public void setSongs(Songs songs) {
        this.songs = songs;
    }
}
