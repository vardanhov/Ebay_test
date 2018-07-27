package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

public class OrganizationView {

    @ApiModelProperty(hidden = true)

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String inn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String kpp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String phone;

    @Override
    public String toString() {
        return "OrganizationView{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
