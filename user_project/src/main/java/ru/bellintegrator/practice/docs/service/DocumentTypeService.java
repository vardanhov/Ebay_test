package ru.bellintegrator.practice.docs.service;

import ru.bellintegrator.practice.docs.view.DocumentTypeView;

import java.util.List;

public interface DocumentTypeService {

    /**
     * List of DocumentTypes
     *
     *
     */

    List<DocumentTypeView> allDocumentType();



    void save(DocumentTypeView view);
}
