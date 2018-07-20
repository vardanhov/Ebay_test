package ru.bellintegrator.practice.user.model;


import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

/**
 * Человек
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "Id")
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

    @Column(name = "doc_code", length = 50, nullable = false)
    private String docCode;

    @Column(name = "doc_name", length = 50, nullable = false)
    private String docName;

    @Column(name = "doc_number", length = 50, nullable = false)
    private String docNumber;


    @Column(name = "doc_date", length = 50, nullable = false)
    private Date docDate;

    @Column(name = "citizenship_name", length = 50, nullable = false)
    private String citizenshipName;

    @Column(name = "citizenship_code", length = 50, nullable = false)
    private String citizenshipCode;




    @ManyToOne
    private Office office;

    @ManyToOne
    private Organization organization;


    public User() {

    }
    public User(String firstName, String secondName, String middleName, String position, String phone, String docCode, String docName, String docNumber, Date docDate, String citizenshipName, String citizenshipCode,Office office, Organization organization) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docCode = docCode;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.office = office;
        this.organization = organization;
    }



    public Long getId() {
        return id;
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

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }


}
