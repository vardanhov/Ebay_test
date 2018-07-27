package ru.bellintegrator.practice.docs.dao;

import ru.bellintegrator.practice.docs.model.DocumentType;


import java.util.List;

public interface DocumentTypeDao  {
    List<DocumentType> all();

    DocumentType findByName(String name);


    DocumentType findByCode(String code);


}
