/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.repository.CancelBidRepository;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.CancelBid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jean-Paul
 */
public class CancelBidRepositoryTest {

    public static ApplicationContext ctx;
    private CancelBidRepository repo;
    private Long id;

    public CancelBidRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void cancelBid() {

        repo = ctx.getBean(CancelBidRepository.class);
        CancelBid can = new CancelBid.Builder("yes")
                .build();
        repo.save(can);
        id = can.getId();
        Assert.assertNotNull(can);
    }

    @Test(dependsOnMethods = "cancelBid")
    public void readBid() {
        repo = ctx.getBean(CancelBidRepository.class);
        CancelBid b = repo.findOne(id);
        Assert.assertEquals(b.getCancelled(), "yes");

    }
    
    @Test(dependsOnMethods = "readBid")
    private void updateBid() {
        repo = ctx.getBean(CancelBidRepository.class);
        CancelBid b = repo.findOne(id);
        CancelBid updatedBid = new CancelBid.Builder()
                .b(b)
                .cancelled("no")
                
                .build();

        repo.save(updatedBid);

        CancelBid newBid = repo.findOne(id);
        Assert.assertEquals(newBid.getCancelled(), "no");//201.0

    }
    
    //@Test(dependsOnMethods = "readBid")
    @Test(dependsOnMethods = "updateBid")
    private void deleteBid() {
        repo = ctx.getBean(CancelBidRepository.class);
        CancelBid b = repo.findOne(id);
        repo.delete(b);

        CancelBid deletedBid = repo.findOne(id);

        Assert.assertNull(deletedBid);

    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
