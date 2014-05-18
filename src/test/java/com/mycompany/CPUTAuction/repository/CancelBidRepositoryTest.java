/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.repository;

import static com.mycompany.CPUTAuction.repository.AccountRepositoryTest.ctx;
import com.mycompany.cputauctionnew.repository.CancelBidRepository;
import static com.mycompany.CPUTAuction.repository.BidRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.CancelBid;
import com.mycompany.cputauctionnew.repository.BidRepository;
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
