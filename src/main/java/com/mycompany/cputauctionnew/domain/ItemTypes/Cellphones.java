/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

/**
 *
 * @author Jean-Paul
 */
public class Cellphones {

    private String id;
    private String brand;
    private double price;
    private String name;

    //private CellPhones(){}
    
    private Cellphones(Builder builder) {
        id = builder.id;
        //brand = builder.brand;
       // price= builder.price;
       //name= builder.name;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private String id;
        private String brand;
        private double price;
        private String name;

        public Builder() {
        }

        public Builder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Cellphones build() {
            return new Cellphones(this);
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

        Cellphones cellphones = (Cellphones) o;

        if (!id.equals(cellphones.id)) {
            return false;
        }

        return true;
    }

    public String getID() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
