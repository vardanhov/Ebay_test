package ru.bellintegrator.practice.organization.model;


import org.hibernate.annotations.Type;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.view.OrganizationUpdateView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;



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


    @Type(type = "true_false")
    @NotNull(message = "NOT_NULL")
    @Column(name = "isActive", nullable = false)
    private Boolean isActive;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Office> offices = new HashSet<>();


    public Organization() {
    }

    public Organization(String name, String fullName, String inn, String kpp, String address,
                        String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
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

    public Set<Office> getOffices() {
        return offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public void update(OrganizationUpdateView update) {
        this.name = update.getName();
        this.fullName = update.getFullName();
        this.inn = update.getInn();
        this.kpp = update.getKpp();
        this.address = update.getAddress();
        this.phone = update.getPhone();
        this.isActive = update.getActive();
    }
}