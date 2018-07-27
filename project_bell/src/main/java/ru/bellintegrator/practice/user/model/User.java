package ru.bellintegrator.practice.user.model;


import org.hibernate.annotations.Type;
import ru.bellintegrator.practice.countries.model.Country;
import ru.bellintegrator.practice.docs.model.Document;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.user.view.UserUpdateView;


import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "second_Name", length = 50, nullable = false)
    private String secondName;

    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    @Column(name = "position", length = 50, nullable = false)
    private String position;

    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Type(type = "true_false")
    @NotNull(message = "NOT_NULL")
    @Column(name = "isIdentified", nullable = false)
    private Boolean isIdentified;

    @Column(name = "active")
    private Boolean isActive;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "office_id")
    private Office office;



    public User() {

    }
    public User(Document document, Country country, Office office, String firstName, String secondName,
                String middleName, String position, String phone, Boolean isIdentified) {
        this.document = document;
        this.country = country;
        this.office = office;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.isIdentified = isIdentified;
    }



    public Long getId() {
        return id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public void update(UserUpdateView update,  Country country) {
        this.firstName = update.getFirstName();
        this.secondName = update.getSecondName();
        this.middleName = update.getMiddleName();
        this.position = update.getPosition();
        this.phone = update.getPhone();
        this.country = country;
        this.isIdentified = update.getIdentified();
    }

}
