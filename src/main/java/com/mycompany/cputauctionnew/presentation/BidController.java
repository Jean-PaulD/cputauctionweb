/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.presentation;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.services.BidsAmountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jean-Paul
 */
@Controller
public class BidController {
    
    
    @Autowired
    private BidsAmountService bidsAmount;
    
    //@Autowired
    //private PersonService personServices;

    @RequestMapping(value = "bid")
    @ResponseBody
    public Bid getBid() {
        Bid p = null;
        List<Bid> bids = bidsAmount.findAll();

        System.out.println(" THE COllection Size" + bids.size());

        if (bids.size() > 0) {
            p = bids.get(0);

        }

        return p;
    }

    @RequestMapping(value = "bids")
    @ResponseBody
    public List<Bid> getBids() {
        return bidsAmount.findAll();

    } 
}
