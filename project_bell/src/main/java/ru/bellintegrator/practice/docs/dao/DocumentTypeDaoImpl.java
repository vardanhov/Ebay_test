package ru.bellintegrator.practice.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.docs.model.DocumentType;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;


public  class DocumentTypeDaoImpl implements DocumentTypeDao {
    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<DocumentType> all() {
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
        return query.getResultList();
    }

    @Override
    public DocumentType findByName(String name) {
        return null;
    }

    @Override
    public DocumentType findByCode(String code) {
        return null;
    }


}
