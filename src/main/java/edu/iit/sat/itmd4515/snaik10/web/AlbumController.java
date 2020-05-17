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
import edu.iit.sat.itmd4515.snaik10.service.SingerService;
import java.util.AbstractList;
import java.util.ArrayList;
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
public class AlbumController {

    private Album album;
    private List<Singer> addSinger;
    private Listener listener;
    private List<Songs> addSongs;

    @EJB
    ListenerService listenerServ;
    @EJB
    AlbumService albumServ;
    @EJB
    SingerService singerServ;

    @Inject
    LoginController loginController;

    /**
     *Initializing the Constructor
     */
    public AlbumController() {
    }

    @PostConstruct
    private void postConstruct() {

        addSinger = new ArrayList<>();
        album = new Album();
        addSongs = new ArrayList<>();
        listener = listenerServ.findByUsername(loginController.getAuthenticatedUser());

    }

    private static final Logger LOG = Logger.getLogger(AlbumController.class.getName());

    //ActionMethod

    /**
     *Adds album to database
     * @return
     */
    public String addAlbum() {

        LOG.info("Inside the addAlbum method" + album.toString());
        this.album.setTotal_Songs(this.addSongs.size());
        albumServ.addSongsToAlbum(album, this.addSongs);
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }

    /**
     *Updates album in database
     * @return
     */
    public String updateAlbum() {
        
        this.album.setTotal_Songs(this.album.getSongs().size());
        albumServ.updateSongInAlbum(album, this.album.getSongs());
//        albumServ.updateSingerInAlbum(album,this.album.getSinger());
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }

    /**
     *deletes album in database
     * @return
     */
    public String confirmAndRemoveAlbum() {
        LOG.info("Album Controller confirm And Remove Album with " + this.album.toString());
        albumServ.deleteAlbum(this.album);
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }

    /**
     *fetches all albums
     * @return
     */
    public List<Album> getAlbumSong() {

        List<Album> albumSong = new ArrayList<>();
        //List<Album> albumForSong = albumServ.findAll().stream().filter(x-> x.getId() == this.album.getId()).collect(Collectors.toList());

        for (Album a : albumServ.findAll()) {
            List<String> songNames = a.getSongs().stream().map(x -> x.getSongName()).collect(Collectors.toList());
            a.setSong_names(songNames.stream().collect(Collectors.joining("\n", "", "\n")));
            
            List<String> singerNames = a.getSinger().stream().map(x -> x.getFirstName()).collect(Collectors.toList());
            a.setSinger_names(singerNames.stream().collect(Collectors.joining("\n", "", "\n")));
            
            albumSong.add(a);
        }

        return albumSong;
    }
//    
//    public List<Singer> getSinger(){
//    
//    List<Singer> fetchSinger = new ArrayList<>();
//    
//    for (Singer s : singerServ.findAll()){
//                fetchSinger.add(s)
//    }
//    
//    return fetchSinger;
//    }

    /**
     *Initializes the value of Albums by ID
     * Rather fetches albums my the ID selected
     */
    public void initAlbumById() {
        LOG.info("Album Controller initAlbumById with " + this.album.getId());
        this.album = albumServ.find(this.album.getId());
        LOG.info("Album Controller initAlbumById after find " + this.album.toString());
    }

    //Getters and Setters
    /**
     * Get the value of addSongs
     *
     * @return the value of addSongs
     */
    public List<Songs> getAddSongs() {
        return addSongs;
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
    public Album getAlbum() {
        return album;
    }

    /**
     *
     * @param album
     */
    public void setAlbum(Album album) {
        this.album = album;
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

    public List<Singer> getAddSinger() {
        return addSinger;
    }

    public void setAddSinger(List<Singer> addSinger) {
        this.addSinger = addSinger;
    }
    
    

}
