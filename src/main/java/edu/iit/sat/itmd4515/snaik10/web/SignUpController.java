/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.domain.Listener;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.security.Group;
import edu.iit.sat.itmd4515.snaik10.security.User;
import edu.iit.sat.itmd4515.snaik10.service.GroupService;
import edu.iit.sat.itmd4515.snaik10.service.ListenerService;
import edu.iit.sat.itmd4515.snaik10.service.UserService;
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
public class SignUpController {

    /**
     *Constructor
     */
    public SignUpController() {
    }
       
    private Listener listener;
    private List<Songs> addSongs;

    @EJB
    ListenerService listenerServ;
    
    @EJB
    GroupService groupService;
    
    @EJB
    UserService userService;
    
    @Inject
    LoginController loginController;
    
    private static final Logger LOG = Logger.getLogger(ListenerController.class.getName());
    
    /**
     *Initiates all variables
     */
    @PostConstruct
    public void init() {
        
        LOG.info("ListenerController in the PostConstruct Method");
        addSongs = new ArrayList<>();
        listener = new Listener();
        listener.setUser(new User());

    }
    
    /**
     * adds listener to the database
     * accesses the listener by group and adds them to the LISTENER GROUP by default
     *
     * @return
     */
    public String addListener() {
        LOG.info("addListener method with:" + listener.toString());
        this.listener.getUser().setFlag(Boolean.FALSE);
        List<Group> groups = groupService.findAll();
        this.listener.getUser().setGroups(groups.stream().filter(x-> x.getGroupName().equals("LISTENERS")).collect(Collectors.toList()));
        userService.create(this.listener.getUser());
        listenerServ.addListener(listener);
        return "/login.xhtml?faces redirect=true\"";
    }
    
    //Getters and Setters
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
    public List<Songs> getAddSongs() {
        return addSongs;
    }

    /**
     *
     * @param addSongs
     */
    public void setAddSongs(List<Songs> addSongs) {
        this.addSongs = addSongs;
    }
        
        
}
