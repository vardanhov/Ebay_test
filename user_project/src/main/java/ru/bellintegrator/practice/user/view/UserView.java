package ru.bellintegrator.practice.user.view;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class UserView {



    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;


    @NotNull(message = "orgId is required")
    @Min(value = 1, message = "officeId must be more than 0")
    private Long officeId;

    @NotNull(message = "firstName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String firstName;



    @NotNull(message = "secondName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String secondName;



    @NotNull(message = "middleName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String middleName;



    @NotNull(message = "position is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String position;


    @NotNull(message = "phone is required")
    @Size(min = 2, max = 16, message = "Does not match  limit of the symbol")
    private String phone;

    @NotNull(message = "docName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String docName;

    @NotNull(message = "docCode is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String docCode;


    @NotNull(message = "docNumber is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String docNumber;

    @NotNull(message = "docDate is required")
    @Past
    private String docDate;

    @NotNull(message = "citizenshipName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String citizenshipName;


    @NotNull(message = "citizenshipCode is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String citizenshipCode;

    @NotNull(message = "isIdentified is required")

    private boolean isIdentified;

    public UserView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
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


    @JsonGetter(value = "isIdentified")
    public boolean isIdentified() {
        return isIdentified;
    }

    @JsonSetter(value = "isIdentified")
    public void setIdentified(boolean identified) {
        isIdentified = identified;
    }
}