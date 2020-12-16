package com.Mark.PetVet.petVet.models;

import java.util.Objects;

public class UserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dob;
    private String access;

    public UserRequest(String username, String password, String firstName, String lastName, String dob, String access) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequest that = (UserRequest) o;
        return username.equals(that.username) &&
                password.equals(that.password) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                dob.equals(that.dob) &&
                access.equals(that.access);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, dob, access);
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", access='" + access + '\'' +
                '}';
    }
}
