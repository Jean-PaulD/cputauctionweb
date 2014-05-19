/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.services;

import static com.mycompany.CPUTAuction.services.MakeBidServiceTestNewTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.domain.CurrentBid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.repository.CurrentBidRepository;
import com.mycompany.cputauctionnew.services.BidsAmountService;
import com.mycompany.cputauctionnew.services.CheckCurrentBidService;
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
public class CheckCurrentBidTest {

    public CheckCurrentBidTest() {
    }
    public static ApplicationContext ctx;
    private Long id;

    private CurrentBidRepository currentBidRepository;
    private CheckCurrentBidService checkCurrentBidService;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
      @Test
    public void checkCurrentBidtTest() {
        currentBidRepository = ctx.getBean(CurrentBidRepository.class);
        checkCurrentBidService = ctx.getBean(CheckCurrentBidService.class);

        CurrentBid b1 = new CurrentBid.Builder(70)
                .seller("sellerName")
                .build();

        CurrentBid b2 = new CurrentBid.Builder(50)
                .seller("sellerName")
                .build();

        CurrentBid b3 = new CurrentBid.Builder(80)
                .seller("sellerName")
                .build();

        currentBidRepository.save(b1);
        currentBidRepository.save(b2);
        currentBidRepository.save(b3);

        List<CurrentBid> currentBid = checkCurrentBidService.getCurrentBid();
        Assert.assertEquals(currentBid.size(), 3);

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
