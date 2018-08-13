package ru.bellintegrator.practice.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.docs.model.DocumentType;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
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
    public List<DocumentType> all(){
        TypedQuery<DocumentType> query = em.createQuery("SELECT d FROM DocumentType d", DocumentType.class);
        return query.getResultList();
    }

    @Override
    public DocumentType getDocumentTypeByCode(String code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);

        Root<DocumentType> doc = criteria.from(DocumentType.class);
        criteria.where(builder.equal(doc.get("code"), code));

        TypedQuery<DocumentType> query = em.createQuery(criteria);

            return query.getSingleResult();


    }

    @Override
    public void save(DocumentType doc) {
        em.persist(doc);
    }

    public DocumentType getDocumentTypeByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);

        Root<DocumentType> doc = criteria.from(DocumentType.class);
        criteria.where(builder.equal(doc.get("name"), name));

        TypedQuery<DocumentType> query = em.createQuery(criteria);

            return query.getSingleResult();


    }
}
