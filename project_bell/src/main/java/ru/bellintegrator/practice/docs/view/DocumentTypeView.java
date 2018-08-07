package ru.bellintegrator.practice.docs.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentTypeView {
    @ApiModelProperty(hidden = true)

    public String name;
    public String code;

    public DocumentTypeView() {
    }

    public DocumentTypeView(String code, String name) {
        this.name = name;
        this.code = code;
    }
}