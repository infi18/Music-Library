/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.domain;

import edu.iit.sat.itmd4515.snaik10.security.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author siddhi
 */
@MappedSuperclass
public class Person extends AbstractEntity {

    /**
     *
     */
    @NotBlank(message = "First Name Cannot be Null")
    protected String firstName;

    /**
     *
     */
    @NotBlank(message = "Last Name Cannot be Null")
    protected String lastName;

    /**
     *
     */
    @Email
    @NotBlank(message = "Email Cannot be Null")
    protected String emailId;

    /**
     *
     */
   
    protected LocalDate DoB;

    @Transient
    private Integer Age;



    /**
     *
     */
    public Person() {
    }

    /**
     *
     * @param First_Name
     * @param Last_Name
     * @param DoB
     * @param Email
     */
    public Person(String First_Name, String Last_Name, String Email, LocalDate DoB) {
        this.firstName = First_Name;
        this.lastName = Last_Name;
        this.emailId = Email;
        this.DoB = DoB;
    }

    @PostLoad
    private void CalAge() {

        if (this.DoB != null) {
            this.Age = Period.between(DoB, LocalDate.now()).getYears();
        }

    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of emailId
     *
     * @return the value of emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Set the value of emailId
     *
     * @param emailId new value of emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Get the value of DoB
     *
     * @return the value of DoB
     */
    public LocalDate getDoB() {
        return DoB;
    }

    /**
     * Set the value of DoB
     *
     * @param DoB new value of DoB
     */
    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }

    /**
     * Get the value of Age
     *
     * @return the value of Age
     */
    public Integer getAge() {
        return Age;
    }

    /**
     * Set the value of Age
     *
     * @param Age new value of Age
     */
    public void setAge(Integer Age) {
        this.Age = Age;
    }



    @Override
    public String toString() {
        return "Person{" + "First_Name=" + firstName + ", Last_Name=" + lastName + ", Email=" + emailId + ", DoB=" + DoB + '}';
    }

}
