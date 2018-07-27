package ru.bellintegrator.practice.user.view;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class UserUpdateView {


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String secondName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String middleName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String position;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String docCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String docName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String docNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date docDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String citizenshipName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String citizenshipCode;


    private Boolean isIdentified;

    public UserUpdateView() {
    }

    public UserUpdateView(Long id, String firstName, String secondName, String middleName, String position,
                             String phone, String docCode, String docName, String docNumber, Date docDate,
                             String citizenshipName, String citizenshipCode, Boolean isIdentified) {
        this.id = id;
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
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public String getDocCode() {
        return docCode;
    }

    public String getDocName() {
        return docName;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    @JsonGetter(value = "isIdentified")
    public Boolean getIdentified() {
        return isIdentified;
    }
}