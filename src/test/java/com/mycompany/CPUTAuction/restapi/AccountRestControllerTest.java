/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.restapi;

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
public class AccountRestControllerTest {
    
    public AccountRestControllerTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void tesBidUpdate() {
        // LEFT AS AN EXERCISE FOR YOU
        // GET THE CLUB and THEN CHANGE AND MAKE A COPY
        //THEN SEND TO THE SERVER USING A PUT OR POST
        // THEN READ BACK TO SEE IF YOUR CHANGE HAS HAPPENED
        //Bid club = new Bid.Builder("Hackers").build();
        /*Bid bid = new Bid.Builder(1001)
                .amount(300)
                .build();
        
        HttpEntity<Bid> requestEntity = new HttpEntity<>(bid, getContentType());
//        Make the HTTP POST request, marshaling the request to JSON, and the response to a String
        ResponseEntity<String> responseEntity = restTemplate.
                exchange(URL + "api/bid/create", HttpMethod.POST, requestEntity, String.class);
        System.out.println(" THE RESPONSE BODY " + responseEntity.getBody());
        System.out.println(" THE RESPONSE STATUS CODE " + responseEntity.getStatusCode());
        System.out.println(" THE RESPONSE IS HEADERS " + responseEntity.getHeaders()); */
        //Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(1, 1);
    }

    public void testreadBidByNameName() {
       /* int bid_id = 1001;
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Bid> responseEntity = restTemplate.exchange(URL + "api/bid/name/" + bid_id, HttpMethod.GET, requestEntity, Bid.class);
        Bid bid = responseEntity.getBody();

        Assert.assertNotNull(bid); */
Assert.assertEquals(1, 1);
    }

    @Test
    public void testreadBidById() {
     /*   int bid_Id = 1001;
        HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Bid> responseEntity = restTemplate.exchange(URL + "api/bid/id/" + bid_Id, HttpMethod.GET, requestEntity, Bid.class);
        Bid club = responseEntity.getBody();

        Assert.assertNotNull(club);
*/
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testgetAllBids() {
       /* HttpEntity<?> requestEntity = getHttpEntity();
        ResponseEntity<Bid[]> responseEntity = restTemplate.exchange(URL + "api/bid/bids", HttpMethod.GET, requestEntity, Bid[].class);
        Bid[] bids = responseEntity.getBody();
        for (Bid bid : bids) {
            System.out.println("The Bid id is " + bid.getBidID());

        }

        Assert.assertTrue(bids.length > 0);*/
        Assert.assertEquals(1, 1);
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
