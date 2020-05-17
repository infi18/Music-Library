/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import edu.iit.sat.itmd4515.snaik10.security.User;
import edu.iit.sat.itmd4515.snaik10.service.UserService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author siddhi
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());


    @Inject
    private SecurityContext securityContext;
    @Inject
    private FacesContext facesContext;
    
    @Inject private UserService userServ;
    
    private User user;
    
    /**
     *Constructor
     */
    public LoginController() {
    }

    /**
     *Initializes all constraints
     */
    @PostConstruct
    private void postConstruct() { 
        
        LOG.info("Inside the LoginController.postConstruct Method");
        //if the user passes authentication fetch username        
            if(facesContext.getExternalContext().getRemoteUser()!= null){
            user = userServ.findByUsername(facesContext.getExternalContext().getRemoteUser());
        }
        else{
                user = new User();
        }

    }
    
    /**
     * Fetch the username of present authenticated user
     * @return
     */
    public String getAuthenticatedUser() {       
        return user.getUsername();
                //facesContext.getExternalContext().getRemoteUser();
    }

    /**
     *Fetch groups of Currently Authenticated User
     * 
     * @return
     */
    public String getAuthenticatedUserGroups() {  
        
        LOG.info("User as group count of: " + user.getGroups().size());
        return user.getGroups().toString();   

    }
    
    /**
     *Check user if user is admin
     * @return
     */
    public boolean isAdmin(){
    
        return securityContext.isCallerInRole("Administrator");
    }
    
    /**
     *Check user if user is listener
     * @return
     */
    public boolean isListener(){
    
        return securityContext.isCallerInRole("Listener");
    }

    //action method

    /**
     *Checks user for authentication and signs in authorized user 
     * Directs unauthorized users to error page
     * @return
     */
    public String doLogin() {

        //Creating Log of Login Record
        LOG.info("LoginController.doLogin with" + user.getUsername());

        Credential credential = new UsernamePasswordCredential
        (user.getUsername(), new Password(user.getPassword()));

        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(),
                (HttpServletResponse) facesContext.getExternalContext().getResponse(),
                AuthenticationParameters.withParams().credential(credential)
        );

        LOG.info("Authentication Status is:" + status.toString());

        switch (status) {

            case SEND_CONTINUE:
                LOG.info("Send Continue");
                break;
            case SEND_FAILURE:
                LOG.info("Send Failure !!");
                return "/error.xhtml";
            case SUCCESS:
                LOG.info("Login Success");
                break;
            case NOT_DONE:
                LOG.info("Received NOT_DONE");
                return "/error.xhtml";

        }

        //returns a navigation case on sucessful login
        return "/Welcome.xhtml?faces-redirect=true";

    }

    /**
     *Logs user out from the system
     * @return
     */
    public String doLogout() {

        LOG.info("LoginController.doLogout method:" + getAuthenticatedUser());

        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();

        try {
            req.logout();
        } catch (ServletException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            return "/error.xhtml?faces-redirect=true";
        }

        return "/login.xhtml";

    }
    
    //Getter Setters

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
