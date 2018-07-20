package ru.bellintegrator.practice.organization.model;


import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;


@Entity
@Table(name = "Organization")
public class Organization {


    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;


    @Version
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    private String name;


    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;


    @Column(name = "inn", length = 50, nullable = false)
    private String inn;


    @Column(name = "kpp", length = 50, nullable = false)
    private String kpp;


    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID")
    private Set<User> users;



    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID")
    private Set<Office> offices;

    public Organization() {
    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone,Set<User> users, Set<Office> offices) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.users = users;
        this.offices = offices;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }
}
