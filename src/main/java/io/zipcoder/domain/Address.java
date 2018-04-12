package io.zipcoder.domain;

public class Address {
    private Long id;
    private String streen_number;
    private String street_name;
    private String city;
    private String state;
    private String zip;

    public Address(Long id, String streen_number, String street_name, String city, String state, String zip) {
        this.id = id;
        this.streen_number = streen_number;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address(String streen_number, String street_name, String city, String state, String zip) {
        this.streen_number = streen_number;
        this.street_name = street_name;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreen_number() {
        return streen_number;
    }

    public void setStreen_number(String streen_number) {
        this.streen_number = streen_number;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
