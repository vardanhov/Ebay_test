package ru.bellintegrator.practice.docs.model;

import ru.bellintegrator.practice.user.model.User;
import javax.persistence.*;
import java.util.Date;

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
    private Date date;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "doc_type_id")
    private DocumentType documentType;




    public Document(DocumentType documentType, String number, Date date) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


