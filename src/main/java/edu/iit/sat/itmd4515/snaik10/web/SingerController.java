/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Album;
import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.service.SingerService;
import edu.iit.sat.itmd4515.snaik10.service.SongsService;
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
public class SingerController {

    private static final Logger LOG = Logger.getLogger(SongsController.class.getName());

    private Singer singer;
    private List<Songs> addSongs;

    @EJB
    SingerService singerServ;
    
    
    
    
    @Inject
    LoginController loginController;

    /**
     *Constructor
     */
    public SingerController() {
    }

    /**
     *Initializes all parameters
     */
    @PostConstruct
    public void postConstruct() {

        LOG.info("Inside the SongsController.postConstruct Method");
        singer = new Singer();
        addSongs = new ArrayList<>();
        
    }

    //Methods

    /**
     *add singer
     * @return
     */
    public String addSinger() {

        LOG.info("Inside the addSongs method with:" + singer.toString());
        singerServ.addSingerSongs(singer, this.addSongs);
        return "/Admin/confirmation.xhtml";
    }
    
    /**
     * updates Singer
     * @return
     */
    public String updateSinger() {
       
        singerServ.updateSingerSongs(singer, this.singer.getSongs());
//      singerServ.updateSingerInAlbum(singer,this.singer.getAlbum());
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }

    /**
     *delete singers
     * @return
     */
    public String confirmAndRemoveSinger() {
        LOG.info("Album Controller confirm And Remove Album with " + this.singer.toString());
        singerServ.deleteSinger(this.singer);
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }

    /**
     *Fetches all singers from database
     * @return
     */
    public List<Singer> getSingerSong() {

        List<Singer> singerSong = new ArrayList<>();
        //List<Album> albumForSong = albumServ.findAll().stream().filter(x-> x.getId() == this.album.getId()).collect(Collectors.toList());

        for (Singer sng : singerServ.findAll()) {
            List<String> songNames = sng.getSongs().stream().map(x -> x.getSongName()).collect(Collectors.toList());
            sng.setSong_names(songNames.stream().collect(Collectors.joining("\n", "", "\n")));
            
            List<String> albumNames = sng.getAlbum().stream().map(x -> x.getAlbumName()).collect(Collectors.toList());
            sng.setAlbum_names(albumNames.stream().collect(Collectors.joining("\n", "", "\n")));
            
            singerSong.add(sng);
        }

        return singerSong;
    }

    /**
     **Initializes the value of Singer by ID
     * Rather fetches singer my the ID selected
     */
    public void initSingerById() {
        LOG.info("Singer Controller initSingerById with " + this.singer.getId());
        this.singer = singerServ.find(this.singer.getId());
        LOG.info("Singer Controller initSingerById after find " + this.singer.toString());
    }
    
    //Getters and Setters
    /**
     * Get the value of songs
     *
     * @return the value of songs
     */
    public Singer getSinger() {
        return singer;
    }

    /**
     * Set the value of songs
     *
     * @param singer
     */
    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    /**
     *
     * @return
     */
    public List<Songs> getAddSongs() {
        return addSongs;
    }

    public void setAddSongs(List<Songs> addSongs) {
        this.addSongs = addSongs;
    }
    
    
}

