package ru.bellintegrator.practice.office.view;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class OfficeView {
    @ApiModelProperty(hidden = true)

    @NotNull(message = "id is required")
    @Min(value = 1, message = "id must be more than 0")
    private Long id;

    @NotNull(message = "orgId is required")
    @Min(value = 1, message = "orgId must be more than 0")
    private Long orgId;

    @NotNull(message = "name is required")
    @Size(max = 50, message = "Does not match  limit of the symbol")
    private String name;

    @NotNull(message = "address is required")
    @Size(max = 255, message = "Does not match  limit of the symbol")
    private String address;

    @NotNull(message = "phone is required")
    @Size(max = 12, message = "Does not match  limit of the symbol")
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean getActive() {
        return isActive;
    }

    @JsonSetter(value = "isIdentified")
    public void setActive(boolean active) {
        isActive = active;
    }
}
