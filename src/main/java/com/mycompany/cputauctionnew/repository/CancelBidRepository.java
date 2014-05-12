/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.repository;

import com.mycompany.cputauctionnew.domain.CancelBid;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jean-Paul
 */
public interface CancelBidRepository extends JpaRepository<CancelBid, Long> {
    
}
