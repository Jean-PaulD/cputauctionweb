/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class Logs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private Timestamp log;
    private String tmpLog;

    private Logs() {
    }

    private Logs(Builder builder) {
            id = builder.id;
            tmpLog = builder.tmpLog;
    }

    public Timestamp getLog() {
        return log;
    }

    public String username(String uName) {
        return username;
    }

    public String password(String pWord) {
        return password;
    }

    public long getID() {
        return id;
    }

    public String getTmpLog() {
        return tmpLog;
    }

    public static class Builder {

        private Long id;
        private String username;
        private String password;
        private Timestamp log;
        private String tmpLog;

        public Builder() {
        }

        public Builder(String tmpLog1) {
            tmpLog = tmpLog1;
        }

        public Timestamp getLog() {
            return log;
        }

        public String tmpLog(String i) {
            tmpLog = i;
            return tmpLog;
        }

        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Logs build() {
            return new Logs(this);
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

        Logs logs = (Logs) o;

        if (!id.equals(logs.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
