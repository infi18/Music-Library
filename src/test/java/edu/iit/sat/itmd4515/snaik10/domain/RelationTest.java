///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.sat.itmd4515.snaik10.domain;
//
//import java.time.LocalDateTime;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.Arrays;
//import java.util.List;
//import javax.validation.constraints.Email;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;
//
///**
// *
// * @author siddhi
// */
//public class RelationTest extends AbstractJPATest {
//
//    /**
//     *
//     */
//    public RelationTest() {
//    }
//
//    //Many to one test
//
//    /**
//     *
//     */
//    @Test
//    public void playlist_Songs_OneToMany_Unidirectional_Relation_Test() {
//
//        Songs sg1 = new Songs("SongTest1", "TS2", "DemoSinger", Genre.BWD);
//        
//        List<Songs> songsList = Arrays.asList(sg1);
//        
//        Playlist p1 = new Playlist("General", 1, true);
//
//        p1.setSongs(songsList);
//
//        et.begin();
//        em.persist(sg1);
//        em.persist(p1);
//        et.commit();
//
//        assertEquals(sg1, p1.getSongs().get(0));
//        assertTrue(sg1.getId() > 0);
//        assertTrue(p1.getId() > 0);
//
//    }
//
//    //ManyToMany Biderictional Relationship test between Singer and Album
//
//    /**
//     *
//     */
//    @Test
//    public void singer_album_ManyToMany_Bidirectional_Relation_Test() {
//
//        Singer s1 = new Singer("SingerTest",
//                "One", "tester@gmail.com",
//                LocalDate.of(1990, 01, 13));
//
//        Singer s2 = new Singer("SingerTester",
//                "Two", "tester@demo.com",
//                LocalDate.of(1986, 12, 30));
//
//        Singer s3 = new Singer("SingerTest",
//                "Three", "tester@demo.com",
//                LocalDate.of(1975, 10, 20));
//
//        Album a1 = new Album("Album1");
//        Album a2 = new Album("Album2");
//
//        //below the association between a1,s1 and a2,s2 is added 
//        a1.addSinger(s1);
//        a2.addSinger(s3);
//        s1.getAlbum().add(a1);
//        s3.getAlbum().add(a2);
//
//        et.begin();
//        em.persist(s1);
//        em.persist(s2);
//        em.persist(s3);
//        em.persist(a1);
//        em.persist(a2);
//        et.commit();
//
//        Album gotalbum = em.find(Album.class, a1.getId());
//        System.out.println("Navigating relation from the owning side");
//        System.out.println(a1.toString());
//        for (Singer singer : a1.getSinger()) {
//            System.out.println("\t" + singer.toString());
//        }
//
//        Singer gotsinger = em.find(Singer.class, s1.getId());
//        System.out.println("Navigating relation from the inverse side");
//        System.out.println(s1.toString());
//        for (Album album : s1.getAlbum()) {
//            System.out.println("\t" + album.toString());
//        }
//
//        assertTrue(gotalbum.getSinger().size() > 0);
//        assertTrue(gotsinger.getAlbum().size() > 0);
//
//        
//        //below the association between a1,s1 and a2,s2 is removed 
//        et.begin();
//        a1.removeSinger(s1);
//        a2.removeSinger(s3);
//        s3.getAlbum().remove(a2);
//        s1.getAlbum().remove(a1);
//        et.commit();
//
//        assertTrue(s1.getAlbum().isEmpty());
//        assertTrue(s3.getAlbum().isEmpty());
//        assertTrue(a1.getSinger().isEmpty());
//        assertTrue(a2.getSinger().isEmpty());
//
//        //Cleaning the data
//        et.begin();
//        em.remove(s1);
//        em.remove(s2);
//        em.remove(s3);
//        em.remove(a1);
//        em.remove(a2);
//        et.commit();
//    }
//}