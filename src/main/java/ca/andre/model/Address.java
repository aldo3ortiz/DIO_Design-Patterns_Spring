package ca.andre.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    private String zip;
    private String street;
    private String city;
    private String state;


    public Address() {

    }

    public Address(String street, String city, String state, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    //////////////////////////////// SETTERS

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    //////////////////////////////// GETTERS

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    //////////////////////////////// ToString

    public String toString() {
        String addressToString = street + ", " + city + ", " + state + ", " + zip;
        return addressToString;
    }
}
