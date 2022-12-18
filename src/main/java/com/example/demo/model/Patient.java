package com.example.demo.model;

import com.example.demo.dto.NutritionistDTO;
import com.example.demo.dto.PatientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "name", nullable = false)
    private Date birthday;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "height", nullable = false)
    private double height;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "BMI", nullable = false)
    private double BMI;

    @Column(name = "goal", nullable = false)
    private String goal;

    @Column(name="weightGoal", nullable = false)
    private double weightGoal;

    @Column(name = "disfatPercentage", nullable = false)
    private double disfatPercentage;

    @ElementCollection
    @Column(name = "diseases", nullable = false)
    private List<String> diseases;

    @ElementCollection
    @Column(name = "intolerances", nullable = false)
    private List<String> intolerances;

    @ElementCollection
    @Column(name = "allergies", nullable = false)
    private List<String> allergies;

    @Column(name = "hoursSlept", nullable = false)
    private Integer hoursSlept;

    @ElementCollection
    @Column(name = "unlikeableFood", nullable = false)
    private List<String> unlikeableFood;

    @ElementCollection
    @Column(name = "foodRestricions", nullable = false)
    private List<String> foodRestricions;

    public Patient(String name, String email, String phone, Date birthday, String gender, double height, double weight, double BMI, String goal, double weightGoal, double disfatPercentage, List<String> diseases, List<String> intolerances, List<String> allergies, Integer hoursSlept, List<String> unlikeableFood, List<String> foodRestricions) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.goal = goal;
        this.weightGoal = weightGoal;
        this.disfatPercentage = disfatPercentage;
        this.diseases = diseases;
        this.intolerances = intolerances;
        this.allergies = allergies;
        this.hoursSlept = hoursSlept;
        this.unlikeableFood = unlikeableFood;
        this.foodRestricions = foodRestricions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Double.compare(patient.height, height) == 0 && Double.compare(patient.weight, weight) == 0 && Double.compare(patient.BMI, BMI) == 0 && Double.compare(patient.weightGoal, weightGoal) == 0 && Double.compare(patient.disfatPercentage, disfatPercentage) == 0 && id.equals(patient.id) && name.equals(patient.name) && email.equals(patient.email) && phone.equals(patient.phone) && Objects.equals(birthday, patient.birthday) && Objects.equals(gender, patient.gender) && Objects.equals(goal, patient.goal) && Objects.equals(diseases, patient.diseases) && Objects.equals(intolerances, patient.intolerances) && Objects.equals(allergies, patient.allergies) && Objects.equals(hoursSlept, patient.hoursSlept) && Objects.equals(unlikeableFood, patient.unlikeableFood) && Objects.equals(foodRestricions, patient.foodRestricions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, birthday, gender, height, weight, BMI, goal, weightGoal, disfatPercentage, diseases, intolerances, allergies, hoursSlept, unlikeableFood, foodRestricions);
    }

    public static Patient dtoToEntity(PatientDTO dto){
        return new Patient(dto.getName(), dto.getEmail(), dto.getPhone(), dto.getBirthday(), dto.getGender(), dto.getHeight(), dto.getWeight(), dto.getBMI(), dto.getGoal(), dto.getWeightGoal(), dto.getDisfatPercentage(), dto.getDiseases(), dto.getIntolerances(), dto.getAllergies(), dto.getHoursSlept(), dto.getUnlikeableFood(), dto.getFoodRestricions()) ;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", BMI=" + BMI +
                ", goal='" + goal + '\'' +
                ", weightGoal=" + weightGoal +
                ", disfatPercentage=" + disfatPercentage +
                ", diseases=" + diseases +
                ", intolerances=" + intolerances +
                ", allergies=" + allergies +
                ", hoursSlept=" + hoursSlept +
                ", unlikeableFood=" + unlikeableFood +
                ", foodRestricions=" + foodRestricions +
                '}';
    }
}
