package ru.bellintegrator.practice.office.model;


import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 50, nullable = false)
    private String address;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ID")
    private Set<User> users;

    @ManyToOne
    private Organization organization;

    public Office() {
    }

    public Office( String name, String address, String phone, Set<User> users, Organization organization) {

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.users = users;
        this.organization = organization;
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
    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
