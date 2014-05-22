/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.services.BidsAmountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidsAmountServiceImpl implements BidsAmountService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getBidAbove(double amount) {
        List<Bid> bids = new ArrayList<>();
        List<Bid> allBids = bidRepository.findAll();

        for (Bid bid : allBids) {
            if (bid.getAmount() > amount) {
                bids.add(bid);
            }
        }
        return bids;
    }
    
    @Override
    public List<Bid> findAll() {
       return bidRepository.findAll();
    }
    
    @Override
    public Bid find(Long id) {
        return bidRepository.findOne(id);
    }

    @Override
    public Bid persist(Bid entity) {
        return bidRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bid merge(Bid entity) {

        if (entity.getId() != null) {
            return bidRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Bid entity) {
        bidRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
