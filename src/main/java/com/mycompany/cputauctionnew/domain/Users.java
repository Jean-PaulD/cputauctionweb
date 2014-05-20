/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.util.List;
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
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountType;
    @OneToMany
    @JoinColumn(name = "Users_id")
    private List<Logs> logs;

    private Users() {
    }

    private Users(Builder aThis) {
        id = aThis.id;
        accountType = aThis.accountType;
        logs = aThis.logs;

    }

    public String accountType() {
        return accountType;
    }

    public List<Logs> getLogs() {
        return logs;
    }

    public static class Builder {

        private Long id;
        private String accountType;
        private List<Logs> logs;
        
        public Builder accountType(String i){
            accountType = i;
            return this;
        }
        public Builder users(Users u) {
            id = u.getID();
            accountType = u.accountType();
            logs = u.getLogs();
            return this;
        }

        public Builder() {
        }

        public Builder(String accountType1) {
            accountType = accountType1;

        }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Builder logs(List<Logs> value) {
            logs = value;
            return this;
        }

        public Users build() {
            return new Users(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Users users = (Users) o;

        if (!id.equals(users.id)) {
            return false;
        }

        return true;
    }

    public Long getID() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
