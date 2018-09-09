package com.practice.document.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.practice.document.model.Document;
import javax.persistence.EntityManager;


@Repository
public class DocumentDaoImpl implements DocumentDao {



    @Autowired
    private final EntityManager em;

    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }



    /**
     * save document
     *
     *
     */
    @Override
    public void save(Document document) {

        em.persist(document);
    }




    /**
     * update document
     *
     *
     */
    @Override
    public void update(Document document) {

        em.merge(document);
    }


    /**
     * get document by id
     *
     *
     */

    @Override
    public Document loadById(Long id) {
        return em.find(Document.class, id);
    }
}
