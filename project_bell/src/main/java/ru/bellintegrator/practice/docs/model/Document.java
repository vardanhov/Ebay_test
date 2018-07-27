package ru.bellintegrator.practice.docs.model;

import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;

@Entity
@Table(name = "Document")
public class Document {

    @Id
    private Long id;

    @Version
    private Integer version;


    @Column(name = "number")
    private String number;

    @Column(name = "date")
    private String date;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_type_id")
    private DocumentType documentType;

    /**
     * Конструктор для hibernate
     */
    public Document() {
    }

    public Document(DocumentType documentType, String number, String date) {
        this.documentType = documentType;
        this.number = number;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


