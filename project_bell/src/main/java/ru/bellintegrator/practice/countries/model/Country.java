package ru.bellintegrator.practice.countries.model;


import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "name", length = 50, nullable = false)
    private String name;


    @Column(name = "code", length = 50, nullable = false)
    private String code;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<User> users;

    public Country() {
    }

    public Country(String name, String code) {

        this.name = name;
        this.code = code;

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}