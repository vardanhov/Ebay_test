package ru.bellintegrator.practice.docs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.docs.dao.DocumentTypeDao;
import ru.bellintegrator.practice.docs.model.DocumentType;
import ru.bellintegrator.practice.docs.view.DocumentTypeView;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;




    @Service
    public class DocumentTypeServiceImpl implements DocumentTypeService {
        private final Logger log = LoggerFactory.getLogger(getClass());

        private final DocumentTypeDao docTypeDao;


        @Autowired
        public DocumentTypeServiceImpl(DocumentTypeDao docTypeDao) {
            this.docTypeDao = docTypeDao;
        }

//        @Override
//        @Transactional
//        public List<DocumentTypeView> allDocumentType() {
//            List<DocumentType> documentTypes = docTypeDao.findAll();
//            Function<DocumentType, DocumentTypeView> mapDocumentType = d -> {
//                DocumentTypeView documentTypeView = new DocumentTypeView();
//                documentTypeView.setName (d.getName());
//                documentTypeView.setCode(d.getCode());
//                return documentTypeView;
//            };
//            return documentTypes.stream().map(mapDocumentType).collect(Collectors.toList());
//        }

        @Override
        @Transactional
        public List<DocumentTypeView> allDocumentType() {
            List<DocumentType> all = docTypeDao.all();

            return all.stream()
                    .map(mapDocumentType())
                    .collect(Collectors.toList());
        }

        private Function<DocumentType, DocumentTypeView> mapDocumentType() {
            return p -> {
                DocumentTypeView view = new DocumentTypeView();

                view.name = p.getName();
                view.code = p.getCode();

                log.debug(view.toString());

                return view;
            };
        }
    }

