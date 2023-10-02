package com.example.demo.student;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.time.Period;

//mapping below to our database.
//Entity is for hibernate and tables for our tables in the db.
@Entity
@Table
public class Student {
      @Id
      @SequenceGenerator(
              name="student_sequence",
              sequenceName = "student_sequence",
              allocationSize = 1
      )
      @GeneratedValue(
              strategy= GenerationType.SEQUENCE,
              generator = "student_sequence"
      )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    // we do not want age to be stored in the db instead calculated using year
    // transient basically means no need to have this column in the db
    @Transient
    private Integer age;

    public Student() {

    }

    public Student(long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

// here we have no id bcox the db will generate for us
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        // calculating the age
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
