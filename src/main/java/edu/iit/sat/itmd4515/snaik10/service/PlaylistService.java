/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Playlist;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author siddhi
 */
@Stateless
public class PlaylistService extends AbstractService<Playlist>{

    /**
     *Constructor
     */
    public PlaylistService() {
        
        super(Playlist.class);
    }

    /**
     *Fetches all the playlist
     * @return
     */
    @Override
    public List<Playlist> findAll() {
        return em.createNamedQuery("Playlist.findAll", entityClass).getResultList();
    }
    
    /**
     * add method
     * @param p
     * @param s
     */
    public void addSongsToPlaylist(Playlist p, List<Songs> s){
        List<Songs> sg = new ArrayList<>();
       for(Songs song: s){
       Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
       sg.add(managedEntitySongs);
       }
            p.setSongs(sg);
            create(p);
    }
    
    /**
     *update method 
     * @param p
     * @param s
     */
    public void updateSongsToPlaylist(Playlist p, List<Songs> s){
       List<Songs> sg = new ArrayList<>();
       for(Songs song: s){
       Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
       sg.add(managedEntitySongs);
       }
            p.setSongs(sg);
            update(p);
     }
        
    /**
     *delete method 
     * @param p
     */
    public void deletePlaylist(Playlist p){
//       List<Songs> sg = new ArrayList<>();
//       for(Songs song: s){
//       Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
//       sg.add(managedEntitySongs);
//       }
//            p.setSongs(sg);
            delete(p);
     }
    
}
