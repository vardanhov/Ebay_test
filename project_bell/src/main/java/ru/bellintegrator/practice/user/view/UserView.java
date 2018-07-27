package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class UserView {


    public long id;


    public String firstName;


    public String secondName;


    public String middleName;


    public String position;


    public String phone;


    public String docName;


    public String docNumber;


    public String docDate;


    public String citizenshipName;


    public String citizenshipCode;


    public boolean isIdentified;

    public UserView() {
    }

    public UserView(long id, String firstName, String secondName, String middleName, String position,
                        String phone, String docName, String docNumber, String docDate, String citizenshipName,
                        String citizenshipCode, boolean isIdentified) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.phone = phone;
        this.docName = docName;
        this.docNumber = docNumber;
        this.docDate = docDate;
        this.citizenshipName = citizenshipName;
        this.citizenshipCode = citizenshipCode;
        this.isIdentified = isIdentified;
    }
}