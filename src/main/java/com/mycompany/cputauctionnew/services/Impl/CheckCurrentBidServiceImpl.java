/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.domain.CurrentBid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.repository.CurrentBidRepository;
import com.mycompany.cputauctionnew.services.CheckCurrentBidService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckCurrentBidServiceImpl implements CheckCurrentBidService {

    @Autowired
    private CurrentBidRepository currentBidRepository;

    @Override
    public List<CurrentBid> getCurrentBid() {
        List<CurrentBid> currentBids = new ArrayList<>();
        //CurrentBid currentBids;// = null;
        List<CurrentBid> allBids = currentBidRepository.findAll();

        for (CurrentBid currentBid : allBids) {
            currentBids.add(currentBid);
        }
        return currentBids;
    }
    
    public List<CurrentBid> findAll() {
       return currentBidRepository.findAll();
    }

}
