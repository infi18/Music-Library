///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.sat.itmd4515.snaik10.domain;
//
//import java.time.LocalDateTime;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import javax.persistence.RollbackException;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author siddhi
// */
//public class SongsDemoTest {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//        
//    /**
//     *
//     */
//    @Test
//    public void demoTest() {
//       
//
//        Songs sg = new Songs("Tester","TST2","Singer1",Genre.RK);
//
//        et.begin();
//        //data is persisted but not yet committed
//        em.persist(sg);
//        //data is added only after commit
//        et.commit();
//        
//        
//        //Asserts that data is created and added
//        assertTrue(sg.getId()>0);
//        
//        System.out.println("Demo test is successfull !!!: " + sg.toString());
//        
//        em.close();
//        emf.close();
//
//    }
//    
//    /**
//     *
//     */
//    public void demoTestPassesWithException() {
//        
//        
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//
//         Songs sg = new Songs("Tester","TEST","Singer1",Genre.RK);
//
//        
//        //Here the assert catches the exception trown using lambda function 
//        assertThrows(RollbackException.class, () -> {
//
//            
//            et.begin();
//            em.persist(sg);
//            et.commit();
//        });
//
//        System.out.println("After Entity is COMMITTED - after passing through exception: " + sg.toString());
//}
//}
