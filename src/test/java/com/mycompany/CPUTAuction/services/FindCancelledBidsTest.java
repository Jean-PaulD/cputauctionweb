/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.services;

import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.CancelBid;
import com.mycompany.cputauctionnew.repository.CancelBidRepository;
import com.mycompany.cputauctionnew.services.CancelBidService;
import java.util.List;
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
public class FindCancelledBidsTest {
    
    public FindCancelledBidsTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    public static ApplicationContext ctx;
    private Long id;

    private CancelBidRepository cancelBidRepository;
    private CancelBidService cancelBidService;
   
    @Test
    public void getCancelBid(){
        cancelBidRepository = ctx.getBean(CancelBidRepository.class);
        cancelBidService = ctx.getBean(CancelBidService.class);

        CancelBid s1 = new CancelBid.Builder()
                .cancelled("no")
                .build();
        
        CancelBid s2 = new CancelBid.Builder()
                .cancelled("no")
                .build();
        
        CancelBid s3 = new CancelBid.Builder()
                .cancelled("yes")
                .build();
        
        cancelBidRepository.save(s1);
        cancelBidRepository.save(s2);
        cancelBidRepository.save(s3);
        
        List<CancelBid> s = cancelBidService.getCancelBid();
        Assert.assertEquals(s.size(), 2);
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
       cancelBidRepository = ctx.getBean(CancelBidRepository.class);
       cancelBidRepository.deleteAll();
    }
}
