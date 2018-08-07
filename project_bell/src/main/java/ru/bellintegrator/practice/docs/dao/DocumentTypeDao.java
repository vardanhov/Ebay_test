package ru.bellintegrator.practice.docs.dao;

import ru.bellintegrator.practice.docs.model.DocumentType;
import java.util.List;

public interface DocumentTypeDao  {


    /**
     * List of DocumentTypes
     *
     *
     */


    List<DocumentType> all();

    /**
     * Find DocumtType by name
     *
     *
     */
    DocumentType getDocumentTypeByName(String name);


    /**
     * Find DocumtType by code
     *
     *
     */
    DocumentType getDocumentTypeByCode(String code);


    void save(DocumentType documenttype);

}
