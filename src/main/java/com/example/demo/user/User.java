package com.example.demo.user;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    private int Id;
    private String email_address;
    private String first_name;
    private String last_name;
    private String password;

    public User() {
    }

    public User(int id, String email_address, String first_name, String last_name, String password) {
        Id = id;
        this.email_address = email_address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", email_address='" + email_address + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
