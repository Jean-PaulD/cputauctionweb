/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.repository.SellerRepository;
import static com.mycompany.CPUTAuction.repository.SellerRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Seller;
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
public class SellerRepositoryTest {
    
    public SellerRepositoryTest() {
    }
    
    public static ApplicationContext ctx;
    private Long id;

    private SellerRepository repo;
    
    @Test
    public void createSeller() {

        repo = ctx.getBean(SellerRepository.class);
        Seller u = new Seller.Builder("sellerUsername")
                .build();
        repo.save(u);
        id = u.getID(); 
        Assert.assertNotNull(u);

    }

    @Test(dependsOnMethods = "createSeller")
    public void readSeller() {
        repo = ctx.getBean(SellerRepository.class);
        Seller b = repo.findOne(id);
        Assert.assertEquals(b.getUsername(), "sellerUsername");

    }

    @Test(dependsOnMethods = "readSeller")
    private void updateSeller() {
        repo = ctx.getBean(SellerRepository.class);
        Seller b = repo.findOne(id);
        Seller updatedSeller = new Seller.Builder("normal")
                .build();

        repo.save(updatedSeller);

        Seller newSeller = repo.findOne(id);
        Assert.assertEquals(newSeller.getUsername(), "sellerUsername");//normal

    }

    @Test(dependsOnMethods = "updateSeller")
    private void deleteSeller() {
        repo = ctx.getBean(SellerRepository.class);
        Seller b = repo.findOne(id);
        repo.delete(b);

        Seller deletedSeller = repo.findOne(id);

        Assert.assertNull(deletedSeller);

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
