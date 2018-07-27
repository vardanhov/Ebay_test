package ru.bellintegrator.practice.user.view;

import com.fasterxml.jackson.annotation.JsonInclude;

public class UserSaveView {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String firstName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String secondName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String middleName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String position;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String docCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String docName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String docNumber;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String docDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String citizenshipName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String citizenshipCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public boolean isIdentified;

    public UserSaveView() {
    }

    public UserSaveView(String firstName, String secondName, String middleName, String position, String phone,
                            String docCode, String docName, String docNumber, String docDate, String citizenshipName,
                            String citizenshipCode, boolean isIdentified) {
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
}

