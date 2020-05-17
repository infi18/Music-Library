///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.iit.sat.itmd4515.snaik10.domain;
//
//import javax.persistence.RollbackException;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author siddhi
// */
//public class SongsTest extends AbstractJPATest{
//    
//    /**
//     *
//     */
//    public SongsTest() {
//    }
//
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//
//    /**
//     *
//     */
//    @Test
//    public void createTestPassesAllAssertions() {
//        Songs sg = new Songs("Arziyaan", "ARZYN","A R Rehman",Genre.SUF);
//        
//        //data entry transaction begins 
//        et.begin();
//
//        //sg is new entity object
//        assertNull(sg.getId());
//
//        System.out.println("Before Entity is Persisted - generated value for ID is null:" + sg.toString());
//
//        //data is persisted
//        em.persist(sg);
//        System.out.println("Entity is Persisted - generated value for ID is  still null:" + sg.toString());
//
//        //Only after commit the data is actually added to database 
//        et.commit();
//
//        //Asserts that data is created in database
//        assertNotNull(sg.getId());
//        assertTrue(sg.getId() > 0);
//
//        System.out.println("After Entity is COMMITTED - generated value is available: " + sg.toString());
//
//        //Cleaning the test data so that it doesn't affect any other test cases by removing it
//        et.begin();
//        em.remove(sg);
//        et.commit();
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    //This test can fail as it has duplicate values for primary key
//     //and hence an exception is passed for the test to pass
//    public void createTestFailsAssertions() {
//        
//        
//        em = emf.createEntityManager();
//        et = em.getTransaction();
//
//        Songs sg = new Songs("DemoSong", "DEMO","Singer" ,Genre.JZ);
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
//        
//        System.out.println("After Entity is COMMITTED - after passing through exception: " + sg.toString());
//        
//
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void readTest() {
//        Songs sg = em.createQuery("select s from Songs s where s.songCode = :songCode", Songs.class).
//                setParameter("songCode", "DEMO").
//                getSingleResult();
//
//        //Asserts data is found and read in database
//        assertNotNull(sg.getId());
//        assertTrue(sg.getId() >= 1l);
//        assertEquals("DEMO", sg.getSongCode());
//        
//        System.out.println("Test read is successfull: " + sg.toString());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void updateTest() {
//        Songs sg = em.createQuery("select s from Songs s where s.songCode = :songCode", Songs.class).
//                setParameter("songCode", "DEMO").
//                getSingleResult();
//
//        
//        //Updates values in the database using the setters
//        et.begin();
//        sg.setGenre(Genre.POP);
//        sg.setSongName("Modified DemoTester");
//        et.commit();
//
//        Songs reFindTheEntity = em.find(Songs.class, sg.getId());
//        
//        //Shows the actual and updated entity 
//        System.out.println("Original Entity with updated set methods in Transaction: " + sg.toString());
//        System.out.println("Entity refound from Dtabase to compare: " + reFindTheEntity.toString());
//        
//        //Asserts that data is found in database
//        assertEquals(sg.getGenre(), reFindTheEntity.getGenre()); 
//        assertEquals(sg.getSongName(), reFindTheEntity.getSongName());
//    }
//
//    /**
//     *
//     */
//    @Test
//    public void deleteTest() {
//        
//        //Before the delete test is performed data is added to database
//        Songs sg = new Songs("Arziyaan","ARZYN","A R Rehman",Genre.BWD);
//
//       
//        et.begin();              // begins to add entry in database
//        em.persist(sg);          //transaction is persisted/ added to database 
//        et.commit();             //data entry is  committed
//
//        
//        assertNotNull(sg.getId());      //Asserts that data is created in database
//
//        et.begin();              //transaction begins to remove entry from database
//        em.remove(sg);           //entry is removed from database
//        et.commit();             //remove transaction is committed 
//
//        System.out.println("The Test method has deleted the entry:" + sg.toString());
//
//        Songs reFindTheEntity = em.find(Songs.class, sg.getId());
//        assertNull(reFindTheEntity);
//    }
//}
