/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import static com.mycompany.CPUTAuction.repository.AccountRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.BidsWon;
import com.mycompany.cputauctionnew.repository.BidsWonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jean-Paul
 */
public class BidsWonRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private BidsWonRepository repo;

    
    public BidsWonRepositoryTest() {
    }

    @Test
    public void winBid(){
        repo = ctx.getBean(BidsWonRepository.class);
        BidsWon b = new BidsWon.Builder(50001)
                .seller("John")
                .build();
        repo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);

    }
    
    @Test(dependsOnMethods = "winBid")
    public void readBidsWon() {
        repo = ctx.getBean(BidsWonRepository.class);
        BidsWon b = repo.findOne(id);
        Assert.assertEquals(b.getSeller(), "John");

    }
    
    @Test(dependsOnMethods = "readBidsWon")
    private void updateBidsWon() {
        repo = ctx.getBean(BidsWonRepository.class);
        BidsWon b = repo.findOne(id);
        BidsWon updatedBid = new BidsWon.Builder(1002)
                .bidsWon(b)
                .seller("Jack")
                .build();

        repo.save(updatedBid);

        BidsWon newBid = repo.findOne(id);
        Assert.assertEquals(newBid.getSeller(), "Jack");

    }
    
     @Test(dependsOnMethods = "updateBidsWon")
    private void deleteBid() {
        repo = ctx.getBean(BidsWonRepository.class);
        BidsWon b = repo.findOne(id);
        repo.delete(b);

        BidsWon deletedBid = repo.findOne(id);

        Assert.assertNull(deletedBid);

    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
