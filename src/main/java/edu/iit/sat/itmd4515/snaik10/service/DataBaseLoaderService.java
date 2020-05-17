/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.service;

import edu.iit.sat.itmd4515.snaik10.domain.Album;
import edu.iit.sat.itmd4515.snaik10.domain.Genre;
import edu.iit.sat.itmd4515.snaik10.domain.Listener;
import edu.iit.sat.itmd4515.snaik10.domain.Playlist;
import edu.iit.sat.itmd4515.snaik10.domain.Singer;
import edu.iit.sat.itmd4515.snaik10.domain.Songs;
import edu.iit.sat.itmd4515.snaik10.security.Group;
import edu.iit.sat.itmd4515.snaik10.security.User;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author siddhi
 */
@Startup
@Singleton
public class DataBaseLoaderService {

    @EJB
    SingerService SingerServ;
    @EJB
    AlbumService AlbumServ;
    @EJB
    SongsService SongsServ;
    @EJB
    ListenerService ListenerServ;
    @EJB
    PlaylistService PlaylistServ;
   

    @EJB
    UserService UserServ;
    @EJB
    GroupService GroupServ;

    private static final Logger LOG = Logger.getLogger(DataBaseLoaderService.class.getName());

    /**
     *Initialize database service 
     */
    public DataBaseLoaderService() {
    }
    
    /**
     *Data is added to database on various entities using their service layers 
     */
    
    @PostConstruct
    private void PostConstruct() {
        //Security Service 
        User admin = new User("Admin", "Admin", true);
        Group adminGroup = new Group("ADMINISTRATORS", "Group of all admins");
        admin.AddGroup(adminGroup);

        GroupServ.create(adminGroup);
        UserServ.create(admin);

        Group listenerGroup = new Group("LISTENERS", "Group of all listeners/users of music library");
        GroupServ.create(listenerGroup);

        User listener1 = new User("listener1", "listener1", true);
        listener1.AddGroup(adminGroup);
        listener1.AddGroup(listenerGroup);
        User listener2 = new User("listener2", "listener", true);
        listener2.AddGroup(listenerGroup);
        User listener3 = new User("listener3", "listener3", true);
        listener3.AddGroup(listenerGroup);
        
        UserServ.create(listener1);
        UserServ.create(listener2);
        UserServ.create(listener3);

        //Singer sample data  created below 
        Singer s1 = new Singer("Arijit", "Singh", "arsingh@hotmail.com", LocalDate.of(1987, 4, 25));
        Singer s2 = new Singer("Enrique", "Iglesias", "EnqIgle@gmail.com", LocalDate.of(1975, 5, 8));
        Singer s3 = new Singer("Ellie", "Goulding", "ElGould12@yahoo.com", LocalDate.of(1986, 12, 30));
        Singer s4 = new Singer("Tochi", "Raina", "Traina@yahoo.com", LocalDate.of(1971, 9, 2));
        Singer s5 = new Singer("Dan", "Reynolds", "ImgDrag@yahoo.com", LocalDate.of(1987, 7, 14));
        Singer s6 = new Singer("Rekha", "Bharadwaj", "RekBharadwaj@gmail.com", LocalDate.of(1964, 1, 24));

        SingerServ.create(s1);
        SingerServ.create(s2);
        SingerServ.create(s3);
        SingerServ.create(s4);
        SingerServ.create(s5);
        SingerServ.create(s6);

        //Log of Simger Sample data creation 
        LOG.info("Singer Sample data is created:");
        LOG.info("Singer1 data:" + s1);
        LOG.info("Singer2 data:" + s2);
        LOG.info("Singer3 data:" + s3);
        LOG.info("Singer4 data:" + s4);
        LOG.info("Singer5 data:" + s5);
        LOG.info("Singer6 data:" + s6);
        


        //Album sample data created below
        Album a1 = new Album("Euphoria", LocalDate.of(2010, 7, 5));
        a1.addSinger(s2);
        Album a2 = new Album("Fearless", LocalDate.of(2010, 7, 5));
        a2.addSinger(s3);
        a2.addSinger(s2);
        Album a3 = new Album("Evolve", LocalDate.of(2010, 7, 5), 0);
        a3.addSinger(s5);
        
        
        AlbumServ.create(a1);
        AlbumServ.create(a2);
        AlbumServ.create(a3);

        //Log of Songs Sample data creation 
        LOG.info("Album Sample data is created:");
        LOG.info("Album1 :" + a1);
        LOG.info("Album2 :" + a2);
        LOG.info("Album3 :" + a3);

        //Songs sample data is created below 
        Songs sg1 = new Songs("Thunder", "THun", "Imagine Dragons", Genre.RK);
        sg1.setSinger(s5);
        Songs sg2 = new Songs("Kabira", "KBR", "Tochi Raina", Genre.BWD);
        sg2.setSinger(s4);
        Songs sg3 = new Songs("Kabiraa", "KBra", "Rekha Bharadwaj", Genre.BWD);
        sg3.setSinger(s6);
        Songs sg4 = new Songs("Bairaagi", "Bair", "Arijit Singh", Genre.BWD);
        sg4.setSinger(s1);
        Songs sg5 = new Songs("Love Me Like You Do", "LMLYD", "Ellie Goulding", Genre.POP);
        sg5.setSinger(s3);
        Songs sg6 = new Songs("Why Not Me", "WnNM", "Enrique Iglesias", Genre.POP);
        sg6.setSinger(s2);

        SongsServ.create(sg1);
        SongsServ.create(sg2);
        SongsServ.create(sg3);
        SongsServ.create(sg4);
        SongsServ.create(sg5);
        SongsServ.create(sg6);
        
                
        List<Songs> songs1List = Arrays.asList(sg1,sg2,sg3,sg4);
        List<Songs> songs2List = Arrays.asList(sg1,sg6,sg5,sg4);


        //Log of Songs Sample data creation 
        LOG.info("Songs Sample data is created:");
        LOG.info("Song1 :" + sg1);
        LOG.info("Song2 :" + sg2);
        LOG.info("Song3 :" + sg3);
        LOG.info("Song4 :" + sg4);
        LOG.info("Song5 :" + sg5);
        LOG.info("Song6 :" + sg6);

       
        //Listener sample data created below
        Listener l1 = new Listener(8777177, "Jack", "Hyde",
                "JHyde13@gmail.com", LocalDate.of(1990, 01, 13));
        l1.setUser(listener1);
 
        Listener l2 = new Listener(8989177, "Amy ", "Adams",
                "Adams8@gmail.com", LocalDate.of(1996, 11, 18));
        l2.setUser(listener2);
        Listener l3 = new Listener(8269178, "jane", "Doe",
                "Jdoe@hotmail.com", LocalDate.of(1981, 04, 19));
        l3.setUser(listener3);
           
        ListenerServ.create(l1);
        ListenerServ.create(l2);
        ListenerServ.create(l3);

        //Log of Songs Sample data creation 
        LOG.info("Listener Sample data is created:");
        LOG.info("Listener1 :" + l1);
        LOG.info("Listener2 :" + l2);
        LOG.info("Listener3 :" + l3);

        //Playlist sample data created below
        Playlist p1 = new Playlist("Combo", songs1List.size());
        p1.setListener(l3);
        p1.setSongs(songs1List);
        
        Playlist p2 = new Playlist("Party", songs2List.size());
        p2.setListener(l1);
        p2.setSongs(songs2List);

        Playlist p3 = new Playlist("MixUp", songs2List.size());
        p3.setListener(l2);
        p3.setSongs(songs2List);
        PlaylistServ.create(p1);
        PlaylistServ.create(p2);
        PlaylistServ.create(p3);

        //Log of Songs Sample data creation 
        LOG.info("Playlist Sample data is created:");
        LOG.info("Playlist1 :" + p1);
        LOG.info("Playlist2 :" + p2);
        LOG.info("Playlist3 :" + p3);

    }
}
