package com.mycompany.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class User {


    private String age;
    private String surname;

    @Size(min=0, max=20)
    private String name;

    private String patronymic;
    private String levelSalary;
    private String email;
    private String jobPlace;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLevelSalary() {
        return levelSalary;
    }

    public void setLevelSalary(String levelSalary) {
        this.levelSalary = levelSalary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    @Override
    public String toString() {
        return surname + ", " + name + ", " + age + ", " + patronymic + ", " +levelSalary + ", " +
               email + ", " + jobPlace + ".";
    }
}
