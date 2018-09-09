package com.practice.docs.dao;

import com.practice.docs.model.DocumentType;

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


}
