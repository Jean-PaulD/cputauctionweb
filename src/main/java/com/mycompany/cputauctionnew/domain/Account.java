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
    @Column(unique = true)
    private String name;
    @Column(unique = true)
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

    private Account(String user, String pass, String nm, String sn) {
        password = pass;
        username = user;
        name = nm;
        surname = sn;
    }

    private Account(Builder builder) {
        Bid = builder.Bid;
    }

    public Long getId() {return id;}

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

        public Builder(int i) {
        }

        public Builder name(String nm) {
            return this;
        }

        public Builder surname(String sn) {
            return this;
        }

        public Builder email(String em) {
            return this;
        }

        public Builder password(String string) {
            return this;
        }

        public Builder username(String un) {
            return this;
        }

        public Account build() {
            return new Account(this);
        }

    }
}
