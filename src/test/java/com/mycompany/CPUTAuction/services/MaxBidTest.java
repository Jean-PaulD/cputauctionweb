/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.services;

import static com.mycompany.CPUTAuction.services.CheckItemConditionServiceTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.repository.ItemConditionRepository;
import com.mycompany.cputauctionnew.services.ItemConditionService;
import com.mycompany.cputauctionnew.services.MaxBidService;
import java.util.List;
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
public class MaxBidTest {
    
    public MaxBidTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    public static ApplicationContext ctx;
    private Long id;

    private BidRepository bidRepository;
    private MaxBidService maxBidService;
   
     @Test
    public void checkCondition(){
        bidRepository = ctx.getBean(BidRepository.class);
        maxBidService = ctx.getBean(MaxBidService.class);

        Bid b1 = new Bid.Builder(124)
                .amount(400)
                .build();

        Bid b2 = new Bid.Builder(125)
                .amount(300)
                .build();

        Bid b3 = new Bid.Builder(126)
                .amount(130)
                .build();

        bidRepository.save(b1);
        bidRepository.save(b2);
        bidRepository.save(b3);

        List<Bid> bids = maxBidService.getMaxBid();
        Assert.assertEquals(bids.size(), 1);

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
       bidRepository = ctx.getBean(BidRepository.class);
       bidRepository.deleteAll();
    }
}
