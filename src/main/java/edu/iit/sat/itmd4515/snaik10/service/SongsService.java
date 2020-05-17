/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author siddhi
 */
@Named
@Stateless
public class SongsService extends AbstractService<Songs>{

    /**
     *constructor
     */
    public SongsService() {
        super(Songs.class);
    }

    /**
     *Fetches all the songs
     * @return
     */
    @Override
    public List<Songs> findAll() {
        return em.createNamedQuery("Songs.findAll", entityClass).getResultList();
    }
    
    
}
