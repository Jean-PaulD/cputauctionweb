/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class CancelBid implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int age;
    private String cancelled;
    //@Column(unique = true)
    //private String email;

    private CancelBid() {
    }

    private CancelBid(Builder builder) {
        id = builder.id;
        cancelled = builder.getCancelled();
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getCancelled() {
        return cancelled;
    }

    public static class Builder {

        private Long id;
        private String cancelled;// = "no";

        public Builder() {
        }

        public Builder(String i) {
            cancelled = i;
        }
        public Builder cancelled(String i){
            cancelled = i;
            return this;
        }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public CancelBid build() {
            return new CancelBid(this);
        }

        public Builder b(CancelBid b) {
            id = b.getId();
            cancelled = b.getCancelled();
            return this;
        }

        public String getCancelled() {
            return cancelled;
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
        if (!(object instanceof Bid)) {
            return false;
        }
        CancelBid other = (CancelBid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.CancelBid[ id=" + id + " ]";
    }

}
