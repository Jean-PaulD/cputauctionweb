/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

/**
 *
 * @author Jean-Paul
 */
public class Laptops {
    
    private String id;
    private String brand;
    private double price;
    private String name;

    private Laptops(Laptops.Builder builder) {
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
public Builder(){}
        public Builder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Laptops.Builder id(String value) {
            id = value;
            return this;
        }

        public Laptops build() {
            return new Laptops(this);
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

        Laptops laptops = (Laptops) o;

        if (!id.equals(laptops.id)) {
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
