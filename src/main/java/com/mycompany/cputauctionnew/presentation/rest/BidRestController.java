/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.presentation.rest;

import com.mycompany.cputauctionnew.domain.Bid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jean-Paul
 */
@Controller
@RequestMapping(value = "api/bid")
public class BidRestController {
    
    @RequestMapping(value = "create")
    @ResponseBody
    public String create(@RequestBody Bid person) {
        System.out.println(" Create the Called ");
        return "";
    }

    @RequestMapping(value = "update")
    @ResponseBody
    public String update(@RequestBody Bid person) {
        System.out.println(" Update Called ");
        return "";
    }

    @RequestMapping(value = "bid/{id}")
    @ResponseBody
    public Bid getBid(@PathVariable String id) {
        System.out.println(" ID called ");
        return null;
    }

    @RequestMapping(value = "bids")
    @ResponseBody
    public List<Bid> getBids() {
        System.out.println("The Bids");
        return null;
    }

    @RequestMapping(value = "bid/{name}")
    @ResponseBody
    public Bid getBidyName(@PathVariable String id) {
        System.out.println("The Bid name");
        return null;
    }
    
}
