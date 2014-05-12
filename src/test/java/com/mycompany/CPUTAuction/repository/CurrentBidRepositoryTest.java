/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.domain.CurrentBid;
import com.mycompany.cputauctionnew.repository.CurrentBidRepository;
import org.springframework.context.ApplicationContext;
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
    public void CurrentBid(){
        repo = ctx.getBean(CurrentBidRepository.class);
        CurrentBid b = new CurrentBid.Builder(701)
                .BidPrice(200)
                .seller("sellerName")
                .build();
        repo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);

    }
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
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
