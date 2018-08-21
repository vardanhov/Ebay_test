package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class OrganizationView {
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull(message = "name is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String name;


    @NotNull(message = "fullName is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String fullName;


    @NotNull(message = "inn is required")
    @Size(min = 12, max = 12, message = "Does not match  limit of the symbol")
    private String inn;


    @NotNull(message = "kpp is required")
    @Size(min = 9, max = 9, message = "Does not match  limit of the symbol")
    private String kpp;


    @NotNull(message = "address is required")
    @Size(min = 2, max = 255, message = "Does not match  limit of the symbol")
    private String address;


    @NotNull(message = "phone is required")
    @Size(min = 16, max = 16, message = "Does not match  limit of the symbol")
    private String phone;

    @NotNull(message = "isActive is required")
    @JsonProperty(value = "isActive")
    private boolean isActive;

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


    @JsonGetter(value = "isActive")
    public boolean isActive() {
        return isActive;
    }

    @JsonSetter(value = "isActive")
    public void setActive(boolean active) {
        isActive = active;
    }
}
