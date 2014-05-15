/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

/**
 *
 * @author Jean-Paul
 */
public class ItemBook {
    
    private String id;
    private double price;
    private String name;
    private String bookName;
    
    private ItemBook(ItemBook.Builder builder) {
        price = builder.price;
        name = builder.name;
    }

    public String getCondition() {
        return bookName;
    }

    public static class Builder {

        private String id;
        private double price;

        public Builder() {
        }
        private String name;

        public Builder(double price, String name) {
            this.price = price;
            this.name = name;
        }

        public ItemBook.Builder id(String value) {
            id = value;
            return this;
        }

        public ItemBook build() {
            return new ItemBook(this);
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

        ItemBook itemBook = (ItemBook) o;

        if (!id.equals(itemBook.id)) {
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
