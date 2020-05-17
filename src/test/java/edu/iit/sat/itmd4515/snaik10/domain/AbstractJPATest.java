///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.sat.itmd4515.snaik10.domain;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//
///**
// *
// * @author siddhi
// */
//abstract class AbstractJPATest {
//    
//    protected static EntityManagerFactory emf;
//    protected EntityManager em;
//    protected EntityTransaction et;
//
// 
//    /**
//     *
//     */
//    @BeforeAll
//    public static void beforeAllClass() {
//        emf = Persistence.createEntityManagerFactory("itmd4515testPU");
//    }
//
//    /**
//     *
//     */
//    @AfterAll
//    public static void afterAllClass() {
//        emf.close();
//    }
//
//        /**
//     *
//     */
//    @BeforeEach
//    public void beforeEach() {
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//
//        Songs sg = new Songs("DemoSong", "DEMO","Singer2", Genre.JZ);
//
//        et.begin();
//
//        em.persist(sg);
//        et.commit();
//
//        assertTrue(sg.getId() > 0);
//    }
//
//    /**
//     *
//     */
//    @AfterEach
//    public void afterEach() {
//
//        Songs sg = em.createQuery("select s from Songs s where s.songCode = :songCode", Songs.class).
//                setParameter("songCode", "DEMO").
//                getSingleResult();
//        
//        et.begin();             
//        em.remove(sg);
//        et.commit();
//        em.close();
//    }
//}
