package ru.bellintegrator.practice.countries.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryView {
    @ApiModelProperty(hidden = true)

    public String name;
    public String code;

    public CountryView() {
    }


}