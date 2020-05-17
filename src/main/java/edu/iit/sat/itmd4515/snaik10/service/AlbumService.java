/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Album;
import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author siddhi
 */
@Stateless
public class AlbumService extends AbstractService<Album> {

    /**
     * Constructor
     */
    public AlbumService() {
        super(Album.class);
    }

    /**
     * Fetches all the albums
     *
     * @return
     */
    @Override
    public List<Album> findAll() {
        return em.createNamedQuery("Album.findAll", entityClass).getResultList();
    }

    /**
     * updates album,song in database
     *
     * @param a
     * @param s
     */
    public void updateSongInAlbum(Album a, List<Songs> s) {
        List<Songs> sg = new ArrayList<>();
        for (Songs song : s) {
            Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
            sg.add(managedEntitySongs);
        }
        a.setSongs(sg);
        update(a);
    }

    /**
     *
     * delete method
     *
     * @param a
     */
    public void deleteAlbum(Album a) {

        delete(a);
    }

    /**
     * add songs,album to database
     *
     * @param a
     * @param s
     */
    public void addSongsToAlbum(Album a, List<Songs> s) {
        List<Songs> sg = new ArrayList<>();
//        List<Singer> sng = new ArrayList<>();
        for (Songs song : s) {
            Songs managedEntitySongs = em.getReference(Songs.class, song.getId());
            sg.add(managedEntitySongs);
        }
//        for (Singer singer : sn) {
//            Singer managedEntitySongs = em.getReference(Singer.class, singer.getId());
//            sng.add(managedEntitySongs);
//        }
//         a.setSinger(sng);
        a.setSongs(sg);
       
        create(a);
    }

//    public void addSingerToAlbum(Album a, List<Singer> s) {
//        List<Singer> sg = new ArrayList<>();
//        for (Singer singer : s) {
//            Singer managedEntitySongs = em.getReference(Singer.class, singer.getId());
//            sg.add(managedEntitySongs);
//        }
//        a.setSinger(sg);
//        update(a);
//    }
    /**
     *
     * @param a
     * @param s
     */
    public void updateSingerInAlbum(Album a, List<Singer> s) {
        List<Singer> sg = new ArrayList<>();
        for (Singer singer : s) {
            Singer managedEntitySongs = em.getReference(Singer.class, singer.getId());
            sg.add(managedEntitySongs);
        }
        a.setSinger(sg);
        update(a);
    }

}
