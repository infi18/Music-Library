package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Listener;
import edu.iit.sat.itmd4515.snaik10.domain.Playlist;
import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.security.Group;
import edu.iit.sat.itmd4515.snaik10.security.User;
import edu.iit.sat.itmd4515.snaik10.service.GroupService;
import edu.iit.sat.itmd4515.snaik10.service.ListenerService;
import edu.iit.sat.itmd4515.snaik10.service.PlaylistService;
import edu.iit.sat.itmd4515.snaik10.service.SongsService;
import edu.iit.sat.itmd4515.snaik10.service.UserService;
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
public class ListenerController{
    private Listener listener;
     private Group group;
     private Listener listener2;

    @EJB
    ListenerService listenerServ;
    
    @EJB
    GroupService groupServ;
    
    @EJB
    UserService userService;
    
    @EJB
    PlaylistService playlistService;

    /**
     *
     */
    public ListenerController() {

    }

    private static final Logger LOG = Logger.getLogger(ListenerController.class.getName());

    @PostConstruct
    private void postConstruct() {

        this.listener2 = new Listener();
        this.listener2.setUser(new User());
//        this.listener = listenerServ.findByUsername(loginController.getAuthenticatedUser());
    }

    /**
     *adds listener to database
     * @return
     */
    public String addListener(){
        LOG.info("Inside the addListener method with:" + listener2.toString());
        this.listener2.getUser().setFlag(Boolean.FALSE);
        List<Group> groups = groupServ.findAll();
        this.listener2.getUser().setGroups(groups.stream().filter(x-> x.getGroupName().equals("LISTENERS")).collect(Collectors.toList()));
        userService.create(this.listener2.getUser());
        listenerServ.addListener(listener2);
        return "/Admin/confirmation.xhtml?faces redirect=true\"";
    }
    
    /**
     *adds admin in database
     * @return
     */
    public String addAdmin(){
        LOG.info("Inside the addListener method with:" + listener2.toString());
        this.listener2.getUser().setFlag(Boolean.TRUE);
        List<Group> groups = groupServ.findAll();
        this.listener2.getUser().setGroups(groups.stream().filter(x-> x.getGroupName().equals("ADMINISTRATORS")).collect(Collectors.toList()));
        userService.create(this.listener2.getUser());
        listenerServ.addListener(listener2);
        return "/Admin/confirmation.xhtml?faces redirect=true\"";
    }
  
    /**
     *Updates users in database from Admin
     * @return
     */
    public String updateListener() {
        this.listener2.getUser().setFlag(Boolean.FALSE);
        List<Group> groups = groupServ.findAll();
        this.listener2.getUser().setGroups(groups.stream().filter(x-> x.getGroupName().equals("LISTENERS")).collect(Collectors.toList()));
        userService.update(this.listener2.getUser());
        listenerServ.updateListener(listener2);
//      singerServ.updateSingerInAlbum(singer,this.singer.getAlbum());
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }


    /**
     *deletes user in database
     * @return
     */
    public String confirmAndRemoveListener() {
        LOG.info("Listener Controller confirm And Remove Album with " + this.listener2.toString());
        this.listener2 = listenerServ.findByUsername(this.listener2.getUser().getUsername());
        List<Playlist> playlists= playlistService.findAll();
        List<Playlist> playlistForListener=playlists.stream().filter(x-> x.getListener().getUser().getUsername().equals(this.listener2.getUser().getUsername())).collect(Collectors.toList());
        playlistForListener.forEach(x->{ 
            x.setListener(null);
            x.setSongs(null);
            playlistService.deletePlaylist(x);
        } );
        listenerServ.deleteListener(this.listener2);
        userService.delete(this.listener2.getUser());
        return "/Admin/confirmation.xhtml?faces-redirect=true\"";
    }
 
    /**
     *Initializes the value of Listeners by ID
     * Rather fetches listeners my the ID selected
     */
    public void initListenerById() {
        LOG.info("listener Controller initlistenerById with " + this.listener2.getId());
        this.listener2 = listenerServ.find(this.listener2.getId());
        LOG.info("listener Controller initlistenerById after find " + this.listener2.toString());
    }
 
    
    //Getters and Setters
    /**
     *
     * @return
     */
    public List<Listener> getListeners() {

        return listenerServ.findAll();
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
    public Group getGroup() {
        return group;
    }

    /**
     *
     * @param group
     */
    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     *
     * @return
     */
    public Listener getListener2() {
        return listener2;
    }

    /**
     *
     * @param listener2
     */
    public void setListener2(Listener listener2) {
        this.listener2 = listener2;
    }
    
    
    
}