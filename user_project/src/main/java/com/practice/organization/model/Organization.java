package com.practice.organization.model;

import com.practice.office.model.Office;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Organization")
public class Organization {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Version
    private Integer version;


    @Column(name = "name")
    private String name;


    @Column(name = "full_name")
    private String fullName;


    @Column(name = "inn", length = 50)
    private String inn;


    @Column(name = "kpp", length = 50)
    private String kpp;


    @Column(name = "address", length = 50)
    private String address;


    @Column(name = "phone", length = 50)
    private String phone;



    @Column(name = "isActive", nullable = false)
    private Boolean isActive;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization")
    private List<Office> offices;

    public Organization() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
        office.setOrganization(this);
    }


}