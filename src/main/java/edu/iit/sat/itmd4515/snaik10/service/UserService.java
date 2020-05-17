/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;
import edu.iit.sat.itmd4515.snaik10.security.User;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author siddhi
 */
@Stateless
public class UserService extends AbstractService<User> {

    /**
     *constructor
     */
    public UserService() {
        super(User.class);
    }

    /**
     *Fetches all the users
     * @return
     */
    @Override
    public List<User> findAll() {
        return em.createNamedQuery("User.findAll", entityClass).getResultList();

    }
    
    /**
     *Fetches  the users by username
     * @param Username
     * @return
     */
    public User findByUsername(String Username){
    
        return em.find(User.class, Username);
    
    }
}
