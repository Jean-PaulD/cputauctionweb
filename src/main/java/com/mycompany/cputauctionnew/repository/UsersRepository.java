/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.repository;

import com.mycompany.cputauctionnew.domain.Item;
import com.mycompany.cputauctionnew.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jean-Paul
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
    
}
