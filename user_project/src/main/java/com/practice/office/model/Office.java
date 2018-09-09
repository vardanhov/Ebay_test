package com.practice.office.model;


import com.practice.organization.model.Organization;
import com.practice.user.model.User;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Office")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "name", length = 50)
    private String name;



    @Column(name = "address", length = 50)
    private String address;


    @Column(name = "phone", length = 18)
    private String phone;


    @Column(name = "is_Active")
    private Boolean isActive;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "office")
    private List<User> user;

    public Office() {
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public void addUser(User user) {
        getUser().add(user);
        user.setOffice(this);
    }


}