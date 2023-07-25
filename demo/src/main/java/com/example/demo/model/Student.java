package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
/*Validations:
Return error messages if validations failed*/
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3,message="should have atleast 3 characters")
    private String firstName;
    @NotNull
    @Size(min=3,message="should have atleast 3 characters")
    private String lastName;
    @NotNull(message="age range is greater than 15 and less than equal to 20")
    private LocalDate dob;
    @NotNull(message="Please enter A/B/C")
    private char section;
    @NotNull(message="Please enter Male/Female")
    private String gender;
    @Min(value=0,message="range is 0 to 100")
    @Max(value=100,message="range is 0 to 100")
    @NotNull(message="range is 0 to 100")
    private int marks1;
    @Min(value=0,message="range is 0 to 100")
    @Max(value=100,message="range is 0 to 100")
    @NotNull(message="range is 0 to 100")
    private int marks2;
    @Min(value=0,message="range is 0 to 100")
    @Max(value=100,message="range is 0 to 100")
    @NotNull(message="range is 0 to 100")
    private int marks3;

    private int total ;

    private float average ;

    private String result;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMarks1() {
        return marks1;
    }

    public void setMarks1(int marks1) {
        this.marks1 = marks1;
    }

    public int getMarks2() {
        return marks2;
    }
    public void setMarks2(int marks2) {
        this.marks2 = marks2;
    }

    public int getMarks3() {
        return marks3;
    }

    public void setMarks3(int marks3) {
        this.marks3 = marks3;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getTotal() {
        return total=marks1+marks2+marks3;
    }
    public float getAverage() {
        return average= total / 3;
    }

    public String getResult() {
        if (marks1 >= 35 && marks2 >= 35 && marks3 >= 35) {
            result = "pass";
        } else {
            result = "fail";
        }
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", section=" + section +
                ", gender='" + gender + '\'' +
                ", marks1=" + marks1 +
                ", marks2=" + marks2 +
                ", marks3=" + marks3 +
                ", total=" + total +
                ", average=" + average +
                ", result='" + result + '\'' +
                '}';
    }
}
