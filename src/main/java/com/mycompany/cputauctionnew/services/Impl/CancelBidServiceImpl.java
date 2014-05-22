/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.domain.CancelBid;
import com.mycompany.cputauctionnew.domain.Users;
import com.mycompany.cputauctionnew.repository.CancelBidRepository;
import com.mycompany.cputauctionnew.services.CancelBidService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelBidServiceImpl implements CancelBidService {

    @Autowired
    private CancelBidRepository cancelBidRepository;

    @Override
    public List<CancelBid> getCancelBid() {

        List<CancelBid> cancelBids = new ArrayList<>();
        List<CancelBid> allCancelBids = cancelBidRepository.findAll();

        for (CancelBid cancelBid : allCancelBids) {
            if (cancelBid.getCancelled().equals("yes")) {
                cancelBids.add(cancelBid);
            }
        }

        return cancelBids;
    }

    @Override
    public List<CancelBid> finAll() {
        return cancelBidRepository.findAll();
    }

    @Override
    public CancelBid find(Long id) {
        return cancelBidRepository.findOne(id);
    }

    @Override
    public CancelBid persist(CancelBid entity) {
        return cancelBidRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CancelBid merge(CancelBid entity) {

        if (entity.getId() != null) {
            return cancelBidRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(CancelBid entity) {
        cancelBidRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
