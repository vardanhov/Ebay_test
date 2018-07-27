package ru.bellintegrator.practice.office.view;

import com.fasterxml.jackson.annotation.JsonInclude;


public class OfficeSaveView {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public boolean isActive;

    public OfficeSaveView() {
    }

    public OfficeSaveView(String name, String address, String phone, boolean isActive) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
