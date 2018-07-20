package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;
public class OfficeView {

    @ApiModelProperty(hidden = true)
    public String id;
    public String name;
    public String address;
    public String phone;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
