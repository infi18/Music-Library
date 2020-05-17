/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Album;
import edu.iit.sat.itmd4515.snaik10.domain.Listener;
import edu.iit.sat.itmd4515.snaik10.domain.Playlist;
import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.service.AlbumService;
import edu.iit.sat.itmd4515.snaik10.service.ListenerService;
import edu.iit.sat.itmd4515.snaik10.service.PlaylistService;
import edu.iit.sat.itmd4515.snaik10.service.SongsService;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author siddhi
 */
@Named
@RequestScoped
public class PlaylistController {

    private Playlist playlist;
    private Singer singer;
    private Listener listener;
    private List<Songs> addSongs;

    @EJB
    ListenerService listenerServ;
    @EJB
    PlaylistService playServ;
    @EJB
    SongsService songsServ;

    @Inject
    LoginController loginController;

    /**
     *Constructor Initialization
     */
    public PlaylistController() {

    }

    private static final Logger LOG = Logger.getLogger(PlaylistController.class.getName());

    @PostConstruct
    private void postConstruct() {

        this.singer = new Singer();
        this.playlist = new Playlist();
        this.addSongs = new ArrayList<>();
        this.listener = listenerServ.findByUsername(loginController.getAuthenticatedUser());
    }

    //
    /**
     * ActionMethod
     * 
     * adds playlist
     * @returns JSF page
     */
    public String createPlaylist() {
        
        LOG.info("Inside the create Playlist method" + this.playlist.toString());
        this.listener = listenerServ.findByUsername(loginController.getAuthenticatedUser());
        this.playlist.setListener(this.listener);
        this.playlist.setNumber_of_Songs(this.addSongs.size());
        playServ.addSongsToPlaylist(playlist,this.addSongs);

        


        return "/Listener/Confirmation.xhtml?faces-redirect=true\"";
    }
 
    /**
     *update method
     * @return
     */
    public String updatePlaylist() {
         this.listener = listenerServ.findByUsername(loginController.getAuthenticatedUser());
         this.playlist.setListener(this.listener);
         this.playlist.setNumber_of_Songs(this.playlist.getSongs().size());
         playServ.updateSongsToPlaylist(playlist,this.playlist.getSongs());

        return "/Listener/Confirmation.xhtml?faces-redirect=true\"";
    }
    
    /**
     *delete method
     * @return
     */
    public String confirmAndRemovePlaylist() {
        LOG.info("PlaylistController confirmAndRemovePlaylist with " + this.playlist.toString());
         playServ.deletePlaylist(this.playlist);
        return "/Listener/listenerplaylist.xhtml?faces-redirect=true\"";
    }

    /**
     * Helper Method
     * gets playlists from database
     *
     * @return
     *
     */
    public List<Playlist> getPlaylistSong() {

        List<Playlist> playlistSong = new ArrayList<>();
        List<Playlist> playlistForListener = playServ.findAll().stream().filter(x-> x.getListener().getId() == this.listener.getId()).collect(Collectors.toList());
       
        for (Playlist p : playlistForListener) {
            List<String> songNames = p.getSongs().stream().map(x -> x.getSongName()).collect(Collectors.toList());
            p.setSong_names(songNames.stream().collect(Collectors.joining("\n", "", "\n")));
            playlistSong.add(p);
        }

        return playlistSong;
    }

    /**
    *Initializes Playlist by ID
    * Rather fetches Playlist by ID entered 
     */
    public void initPlaylistById() {
        LOG.info("PlaylistController initPlaylistById with " + this.playlist.getId());
        this.playlist = playServ.find(this.playlist.getId());
        LOG.info("PlaylistController initPlaylistById after find " + this.playlist.toString());
    }
    
    /** 
     * getters and Setters
     *
     * @return
     */
    public List<Songs> getAllSongs() {
        return songsServ.findAll();
    }

    //Getters and Setters

    /**
     * Get the value of addSongs
     *
     * @return the value of addSongs
     */
    public List<Songs> getAddSongs() {
        return this.addSongs;
    }

    /**
     * Set the value of addSongs
     *
     * @param addSongs new value of addSongs
     */
    public void setAddSongs(List<Songs> addSongs) {
        this.addSongs = addSongs;
    }

    /**
     *
     * @return
     */
    public Playlist getPlaylist() {
        return playlist;
    }

    /**
     *
     * @param playlist
     */
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     *
     * @return
     */
    public Listener getListener() {
        return listener;
    }

    /**
     *
     * @param listener
     */
    public void setListener(Listener listener) {
        this.listener = listener;
    }

    /**
     *
     * @return
     */
    public Singer getSinger() {
        return singer;
    }

    /**
     *
     * @param singer
     */
    public void setSinger(Singer singer) {
        this.singer = singer;
    }

}
