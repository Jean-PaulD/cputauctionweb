/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.domain.Account;
import com.mycompany.cputauctionnew.repository.AccountRepository;
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
public class AccountRepositoryTest {
    
    
    public static ApplicationContext ctx;
    private Long id;

    private AccountRepository repo;

    
    public AccountRepositoryTest() {
    }

    @Test
    public void createAccount(){
        
        repo = ctx.getBean(AccountRepository.class);
        Account acc = new Account.Builder(3001)
                .name("Jean-Paul")
                .surname("De Buys")
                .email("jpdebuys@gmail.com")
                .password("1234")
                .username("JP1")
                .build();
        repo.save(acc);
        id = acc.getId();
        Assert.assertNotNull(acc);

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
