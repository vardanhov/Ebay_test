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
     * save DocumentType
     *
     *
     */
    void save(DocumentType documenttype);

}
