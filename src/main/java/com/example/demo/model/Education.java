package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "school")
    private String school;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "year")
    private String year;

    @ManyToOne
    @JoinColumn(name= "nutritionist_id", nullable = false)
    private Nutritionist nutritionist;

    public Education(String school, String city, String country, String year, Nutritionist nutritionist) {
        this.school = school;
        this.city = city;
        this.country = country;
        this.year = year;
        this.nutritionist = nutritionist;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", school='" + school + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", year='" + year + '\'' +
                ", nutritionist=" + nutritionist +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return id == education.id && Objects.equals(school, education.school) && Objects.equals(city, education.city) && Objects.equals(country, education.country) && Objects.equals(year, education.year) && Objects.equals(nutritionist, education.nutritionist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, school, city, country, year, nutritionist);
    }
}
