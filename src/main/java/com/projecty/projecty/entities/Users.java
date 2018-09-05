package com.projecty.projecty.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long user_id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    protected Users() {}

    public Users(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[user_id=%d, firstName='%s', lastName='%s', username='%s', password='%s']",
                user_id, firstName, lastName, username, password);
    }

    public long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
