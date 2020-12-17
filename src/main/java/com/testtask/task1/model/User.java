package com.testtask.task1.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {

    private long id;

    private String firstName;
    private String surname;
    private String email;

    private List<String> phoneNumbers;

    private Set<Role> userRole;

    public User() {
    }

    public User(String firstName, String surname, String email, List<String> phoneNumbers, Set<Role> userRole) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.userRole = userRole;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(phoneNumbers, user.phoneNumbers) && Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, surname, email, phoneNumbers, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", userRole=" + userRole +
                '}';
    }

}