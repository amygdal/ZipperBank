package io.zipcoder.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

//    @Column
//    @ElementCollection(targetClass = Address.class)
//    private Set<Address> address;

    public Customer(Long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
//        this.address = address;
    }

    public Customer(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
//        this.address = address;
    }

    public Customer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

//    public Set<Address> getAddress() {
//        return address;
//    }
//
//    public void setAddress(Set<Address> address) {
//        this.address = address;
//    }
}
