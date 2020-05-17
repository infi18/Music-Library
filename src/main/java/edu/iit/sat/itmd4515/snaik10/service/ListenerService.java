/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Listener;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author siddhi
 */
@Stateless
public class ListenerService extends AbstractService<Listener> {

    /**
     *constructor
     */
    public ListenerService() {
        super(Listener.class);
    }

    /**
     *fetches all the listeners from db
     * @return
     */
    @Override
    public List<Listener> findAll() {
        return em.createNamedQuery("Listener.findAll", entityClass).getResultList();
    }

    /**
     *finds all listeners by username
     * @param username
     * @return
     */
    public Listener findByUsername(String username) {

        return em.createNamedQuery("Listener.findByUsername", Listener.class)
                .setParameter("username", username)
                .getSingleResult();

    }

    /**
     *add method
     * @param l
     */
    public void addListener(Listener l) {
        create(l);
    }

    /**
     * update method
     *
     * @param l
     */
    public void updateListener(Listener l) {

        update(l);
    }

    /**
     * delete method
     *
     * @param l
     */
    public void deleteListener(Listener l) {

        delete(l);
    }

}
