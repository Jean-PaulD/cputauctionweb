/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
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
public class BidRepositoryTest {

    public static ApplicationContext ctx;
    private Long id;

    private BidRepository repo;

    public BidRepositoryTest() {
    }

    @Test
    public void createBid() {

        repo = ctx.getBean(BidRepository.class);
        Bid b = new Bid.Builder(1001)
                .amount(300)
                .build();
        repo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);

    }

    @Test(dependsOnMethods = "createBid")
    public void readBid() {
        repo = ctx.getBean(BidRepository.class);
        Bid b = repo.findOne(id);
        Assert.assertEquals(b.getAmount(), 300);

    }

    @Test(dependsOnMethods = "readBid")
    private void updateBid() {
        repo = ctx.getBean(BidRepository.class);
        Bid b = repo.findOne(id);
        Bid updatedBid = new Bid.Builder(1001)
                .b(b)
                .amount(201)
                .build();

        repo.save(updatedBid);

        Bid newBid = repo.findOne(id);
        Assert.assertEquals(newBid.getAmount(), 300);

    }

    @Test(dependsOnMethods = "updateBid")
    private void deleteBid() {
        repo = ctx.getBean(BidRepository.class);
        Bid b = repo.findOne(id);
        repo.delete(b);

        Bid deletedBid = repo.findOne(id);

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
