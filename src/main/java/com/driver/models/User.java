package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UserName")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "FirstName")
    private String firstName = "test";

    @Column(name = "LastName")
    private String lastName = "test";

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Blog> blogList = new ArrayList<>();


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

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}