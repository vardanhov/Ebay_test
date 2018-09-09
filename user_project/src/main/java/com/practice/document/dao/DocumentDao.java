package com.practice.document.dao;


import com.practice.document.model.Document;


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
