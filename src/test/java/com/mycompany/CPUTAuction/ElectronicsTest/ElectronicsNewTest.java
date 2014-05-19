package com.mycompany.CPUTAuction.ElectronicsTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cputauctionnew.domain.ItemTypes.Electronics;
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
public class ElectronicsNewTest {
    
    public ElectronicsNewTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @Test  (enabled = true)
    public void testCreation() throws Exception {
        Electronics b = new Electronics.Builder().id("90").build();
        Assert.assertEquals(b.getID(), "90");
    }

    @Test
    public void testUpdate() throws Exception {
        Electronics b = new Electronics.Builder().id("90").build();

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
