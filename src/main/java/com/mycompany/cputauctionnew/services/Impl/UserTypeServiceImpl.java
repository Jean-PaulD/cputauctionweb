/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Users;
import com.mycompany.cputauctionnew.domain.Users;
import com.mycompany.cputauctionnew.repository.UsersRepository;
import com.mycompany.cputauctionnew.repository.UsersRepository;
import com.mycompany.cputauctionnew.services.UserTypeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl implements UserTypeService {

    @Autowired
    private UsersRepository usersRepository;

    
    @Override
    public List<Users> getAdmin() {
        List<Users> users = new ArrayList<>();
        List<Users> allUsers = usersRepository.findAll();
        
        for(Users user: allUsers){
            if(user.accountType().equals("admin")){
                users.add(user);
            }
        }
        
        return users;
    }
    
    @Override
    public List<Users> findAll() {
       return usersRepository.findAll();
    }
    
    
    @Override
    public Users find(Long id) {
        return usersRepository.findOne(id);
    }

    @Override
    public Users persist(Users entity) {
        return usersRepository.save(entity);
    }

    @Override
    public Users merge(Users entity) {
        if (entity.getID() != null) {
            return usersRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Users entity) {

        usersRepository.delete(entity);
    }
    
    
}
