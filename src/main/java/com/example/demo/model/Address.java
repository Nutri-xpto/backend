package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name =  "address")
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(name =  "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name =  "zipcode")
    private int zipcode;

    @OneToOne
    @JoinColumn(name= "nutritionist_id", nullable = true)
    private Nutritionist nutritionist;

    public Address(String street, int number, String city, String country, int zipcode, Nutritionist nutritionist) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.nutritionist = nutritionist;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipcode=" + zipcode +
                ", nutritionist=" + nutritionist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && number == address.number && zipcode == address.zipcode && Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(country, address.country) && Objects.equals(nutritionist, address.nutritionist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, city, country, zipcode, nutritionist);
    }

}
