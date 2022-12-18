package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class PatientDTO {

    private String name;

    private String email;

    private String phone;

    private Date birthday;

    private String gender;

    private double height;

    private double weight;

    private double BMI;

    private String goal;

    private double weightGoal;

    private double disfatPercentage;

    private List<String> diseases;

    private List<String> intolerances;

    private List<String> allergies;

    private Integer hoursSlept;

    private List<String> unlikeableFood;

    private List<String> foodRestricions;

    public PatientDTO(String name, String email, String phone, Date birthday, String gender, double height, double weight, double BMI, String goal, double weightGoal, double disfatPercentage, List<String> diseases, List<String> intolerances, List<String> allergies, Integer hoursSlept, List<String> unlikeableFood, List<String> foodRestricions) {
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
    public String toString() {
        return "PatientDTO{" +
                "name='" + name + '\'' +
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
