/*
 * BaseTestClass.java
 *
 * Created on 22 February 2007, 12:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package uk.icat3.util;

import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * Extend this when you want setUp and tear down to be called one in the class and not after and before every @Test method
 *
 * @author gjd37
 */
public class BaseTestClass extends BaseTest{
    
    private static Logger log = Logger.getLogger(BaseTestClass.class);
    
    
    @BeforeClass
    public static void setUp(){
        
        log.debug("setUp(), creating entityManager");
        emf = Persistence.createEntityManagerFactory("icat3-core-testing-PU");
        em = emf.createEntityManager();
        EntityManagerResource.getInstance().set(em);
        
        // Begin transaction
        em.getTransaction().begin();
        
        
    }
    
    @AfterClass
    public static void tearDown(){
        
        log.debug("tearDown(), closing entityManager");
        // Commit the transaction
        em.getTransaction().commit();
        
        em.close();
    }
    
    
}