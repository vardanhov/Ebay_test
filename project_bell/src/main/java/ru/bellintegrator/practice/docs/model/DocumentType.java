package ru.bellintegrator.practice.docs.model;

import javax.persistence.*;


@Entity
@Table(name = "Doc_Type")
public class DocumentType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;


    @Column(name = "name")
    private String name;


    @Column(name = "code")
    private String code;



    public DocumentType() {
    }
    public DocumentType(String name, String code) {

        this.name = name;
        this.code = code;

    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}