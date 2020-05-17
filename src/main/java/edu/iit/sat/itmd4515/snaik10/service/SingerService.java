/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;


import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author siddhi
 */
@Stateless
public class SingerService extends AbstractService<Singer>{

    /**
     *constructor
     */
    public SingerService() {
        super(Singer.class);
    }

    /**
     *Fetches all the singers
     * @return
     */
    @Override
    public List<Singer> findAll() {
        return em.createNamedQuery("Singer.findAll", entityClass).getResultList();
    }
    
    /**
     *add method
     * @param sng
     * @param s
     */
    public void addSingerSongs(Singer sng, List<Songs> s){
        List<Songs> sg = new ArrayList<>();
       for(Songs song: s){
       Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
       sg.add(managedEntitySongs);
       }
            sng.setSongs(sg);
            create(sng);
    }
    
    /**
     *update method 
     * @param sng
     * @param s
     */
    public void updateSingerSongs(Singer sng, List<Songs> s){
       List<Songs> sg = new ArrayList<>();
       for(Songs song: s){
       Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
       sg.add(managedEntitySongs);
       }
            sng.setSongs(sg);
            update(sng);
     }
        
    /**
     *delete method 
     * @param sng
     */
    public void deleteSinger(Singer sng){

            delete(sng);
     }
    
}
