/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.domain.CancelBid;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface CancelBidService {

    public List<CancelBid> getCancelBid();
    public List<CancelBid> finAll();
    public CancelBid find(Long id);
    public CancelBid persist(CancelBid entity);
    public CancelBid merge(CancelBid entity);
    public void remove(CancelBid entity);
}
