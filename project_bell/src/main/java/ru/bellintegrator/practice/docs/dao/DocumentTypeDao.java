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
    DocumentType findByName(String name);


    /**
     * Find DocumtType by code
     *
     *
     */
    DocumentType findByCode(String code);


}
