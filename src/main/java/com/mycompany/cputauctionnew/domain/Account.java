/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String name;
    //@Column(unique = true)
    private String surname;
    private int age;
    @Column(unique = true)
    private String email;
    private String itemID;
    private String password;
    @Column(unique = true)
    private String username;
    @OneToMany
    @JoinColumn(name = "Account_id")
    private List<Bid> Bid;
    
    private Account() {
    }

    private Account(Builder builder) {
        //Bid = builder.Bid;
        id = builder.id;
        name= builder.name;
        surname= builder.surname;
        age= builder.age;
        email= builder.email;
        itemID= builder.itemID;
        password= builder.password;
        username= builder.username;
    }

    public String getUsername(){
        return username;
    }
    
    public Long getId() {
        return id;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String surname;
        private int age;
        private String email;
        private String itemID;
        private String password;
        private String username;
        private List<Bid> Bid;

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder(String i) {
            email = i;
        }

        public Builder name(String nm) {
            name = nm;
            return this;
        }

        public Builder surname(String sn) {
            surname = sn;
            return this;
        }

        public Builder password(String string) {
            password = string;
            return this;
        }

        public Builder username(String un) {
            username = un;
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.Account[ id=" + id + " ]";
    }

}
