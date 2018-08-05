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
    /**
     * List of DocumentTypes
     *
     *
     */
    @Override
    public List<DocumentType> all() {
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
        return query.getResultList();
    }

    /**
     * Find DocumtType by name
     *
     *
     */
    @Override
    public DocumentType findByName(String name) {
        return null;
    }


    /**
     * Find DocumtType by code
     *
     *
     */
    @Override
    public DocumentType findByCode(String code) {
        return null;
    }


}
