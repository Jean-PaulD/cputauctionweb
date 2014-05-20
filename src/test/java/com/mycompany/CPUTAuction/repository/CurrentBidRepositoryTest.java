/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import static com.mycompany.CPUTAuction.repository.AccountRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.CurrentBid;
import com.mycompany.cputauctionnew.repository.CurrentBidRepository;
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
public class CurrentBidRepositoryTest {
    
    public CurrentBidRepositoryTest() {
    }
    
    public static ApplicationContext ctx;
    private Long id;

    private CurrentBidRepository repo;

    @Test
    public void currentBid(){
        System.out.println("CurrentBid mthod we in now");
        repo = ctx.getBean(CurrentBidRepository.class);
        CurrentBid b = new CurrentBid.Builder(70)
                .seller("sellerName")
                .build();
        repo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);

    }
    
    @Test(dependsOnMethods = "currentBid")
    public void readBid() {
        repo = ctx.getBean(CurrentBidRepository.class);
        CurrentBid b = repo.findOne(id);
        Assert.assertEquals(b.getBidPrice(), 70.0);

    }
    
    @Test(dependsOnMethods = "readBid")
    private void updateBid() {
        repo = ctx.getBean(CurrentBidRepository.class);
        CurrentBid b = repo.findOne(id);
        CurrentBid updatedBid = new CurrentBid.Builder()
                .currentBid(b)
                .bidPrice(80.0)
                .build();

        repo.save(updatedBid);

        CurrentBid newBid = repo.findOne(id);
        Assert.assertEquals(newBid.getBidPrice(), 80.0);//201.0

    }
    
    @Test(dependsOnMethods = "updateBid")
    private void deleteBid() {
        repo = ctx.getBean(CurrentBidRepository.class);
        CurrentBid b = repo.findOne(id);
        repo.delete(b);

        CurrentBid deletedBid = repo.findOne(id);

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
