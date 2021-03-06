package com.codegym.cms.model;

import lombok.Data;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "customers")
@Component
@Data
public class Customer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public Customer() {
    }

    public Customer( Long id,String name, String email, String phone, String address, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.country = country;
    }

    public Customer(String name, String email, String phone, String address, Country country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", country=" + country.getName() +
                '}';
    }


}
