package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class User {

    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min = 5)
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    private LocalDate dateAdded;

    private static int nextId;

    private Integer id = 1;

    public User(){
        id = nextId;
        dateAdded = LocalDate.now();
        nextId++;
    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void checkPassword(){
        if ((password != null || verifyPassword != null) && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
