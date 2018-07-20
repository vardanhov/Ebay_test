package ru.bellintegrator.practice.user.view;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

public class UserView {

    @ApiModelProperty(hidden = true)
    public String id;
    public String firstName;
    public String secondName;
    public String middleName;
    public String position;
    public String phone;
    public String docCode;
    public String docName;
    public String docNumber;
    public Date docDate;
    public String citizenshipName;
    public String citizenshipCode;


    @Override
    public String toString() {

        return "{id:" + id + ";firstname:" + firstName + ";secondName" + secondName +
                ";middleName" + middleName +";position" + position +";phone" + phone +
                ";docCode" + docCode +";docName" + docName +";docNumber" + docNumber +
                ";docDate" + docDate+ ";citizenshipName" + citizenshipName+ ";citizenshipCode" + citizenshipCode+"}";
    }
}