package ca.andre.model;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    private String name;
    @ManyToOne
    private Address address;

    public Client() {

    }

    public Client(int code, String name, Address address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    //////////////////////////////// SETTERS

    public void setCode(int code) {
        this.code = code;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //////////////////////////////// GETTERS

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public Address getAddress() {
        return address;
    }


    //////////////////////////////// ToString


    public String toString() {
        String clientToString = code + ", " + name + ", " + address;
        return clientToString;
    }
}
