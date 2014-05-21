/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.services;

import com.mycompany.cputauctionnew.services.GetSellerService;
import static com.mycompany.CPUTAuction.services.MaxBidTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Seller;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.repository.SellerRepository;
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
public class FindSellerTest {
    
    public FindSellerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    public static ApplicationContext ctx;
    private Long id;

    private SellerRepository sellerRepository;
    private GetSellerService setSellerService;
   
    @Test
    public void getSeller(){
        sellerRepository = ctx.getBean(SellerRepository.class);
        setSellerService = ctx.getBean(GetSellerService.class);

        Seller s1 = new Seller.Builder()
                .username("Jack")
                .build();
        
        Seller s2 = new Seller.Builder()
                .username("ABC")
                .build();
        
        Seller s3 = new Seller.Builder()
                .username("Mike")
                .build();
        
        sellerRepository.save(s1);
        sellerRepository.save(s2);
        sellerRepository.save(s3);
        
        List<Seller> s = setSellerService.getSeller("ABC");
        Assert.assertEquals(s.size(), 1);
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
       sellerRepository = ctx.getBean(SellerRepository.class);
       sellerRepository.deleteAll();
    }
}
