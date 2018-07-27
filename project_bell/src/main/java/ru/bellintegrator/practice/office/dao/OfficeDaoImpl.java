package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.view.OfficeUpdateView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;



@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }



    @Override
    public List<Office> allOffice() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }


    @Override
    public Office findOfficeById(Long id) {

        return em.find(Office.class, id);
    }


    @Override
    public void save(Office office) {
        em.persist(office);
    }


    @Override
    public void updateOffice(OfficeUpdateView update) {
        Office office = em.find(Office.class, update.getId());

        office.update(update);
        em.merge(office);
    }
}

