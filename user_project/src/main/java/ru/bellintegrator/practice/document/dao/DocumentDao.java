package ru.bellintegrator.practice.document.dao;


import ru.bellintegrator.practice.document.model.Document;


public interface DocumentDao {



    /**
     * save document
     *
     *
     */

     void save(Document document) ;


    /**
     * get document by id
     *
     *
     */

    Document loadById(Long id);

    /**
     * update document
     *
     *
     */

    void update(Document document);


}
