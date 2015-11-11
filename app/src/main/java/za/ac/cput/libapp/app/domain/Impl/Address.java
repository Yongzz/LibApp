package za.ac.cput.libapp.app.domain.Impl;

import java.io.Serializable;

/**
 * Created by Yongama on 2015-04-24.
 */
public class Address implements Serializable{
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private int houseNumber;
    private String street;
    private String suburb;
    private String postalCode;

    private Address(){}
    public Address(Builder builder){
        houseNumber = builder.houseNumber;
        street = builder.street;
        suburb = builder.suburb;
        postalCode = builder.postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder{
        private int houseNumber;
        private String street;
        private String suburb;
        private String postalCode;

        public Builder houseNumber(int value){
            this.houseNumber = value;
            return this;
        }
        public Builder street(String value){
            this.street = value;
            return this;
        }
        public Builder suburb(String value){
            this.suburb = value;
            return this;
        }

        public Builder postalCode(String value){
            this.postalCode = value;
            return this;
        }
        public Builder copy(Address value){
            this.houseNumber = value.houseNumber;
            this.street = value.street;
            this.suburb = value.suburb;
            this.postalCode = value.getPostalCode();
            return this ;
        }
        public Address build(){
            return new Address(this);
        }

    }
}
