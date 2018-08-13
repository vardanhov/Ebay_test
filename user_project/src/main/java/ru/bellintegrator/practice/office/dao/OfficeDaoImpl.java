package ru.bellintegrator.practice.office.dao;


import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.organization.dao.OrganizationDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    private OrganizationDaoImpl orgDao;

    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Get Office by id
     *
     *
     */
    @Override
    public OfficeView getById(Long id) {
        Office office = em.find(Office.class, id);
        if (office==null)
            throw new IllegalArgumentException("Офис не найден");

        OfficeView view = new OfficeView();
        view.setId(office.getId()) ;
        view.setOrgId(office.getOrganization().getId());
        view.setName(office.getName());
        view.setAddress(office.getAddress());
        view.setPhone(office.getPhone());
        view.setActive(office.getActive());
        return view;
    }


    /**
     * Save Office
     *
     *
     */
    @Override
    public void save(OfficeView view) {

        Office office = new Office();
        office.setName(view.getName());
        office.setAddress(view.getAddress());
        office.setPhone(view.getPhone());
        office.setActive(view.getActive());
        orgDao.loadById(view.getOrgId()).addOffice(office);

        em.persist(office);

    }

    /**
     * Update Office
     *
     *
     */
    @Override
    public void update(OfficeView update) {
        Office office = em.find(Office.class, update.getId());
        if (office == null) {
            throw new NullPointerException("Нет такой офис");
        }

        office.setName(update.getName());
        office.setAddress(update.getAddress());
        office.setPhone(update.getPhone());
        office.setActive(update.getActive());
        em.merge(office);
    }


    /**
     * Delete Office
     *
     *
     */
    @Override
    public void delete(Long id) {
        Office office = em.find(Office.class, id);
        em.remove(office);
    }

    /**
     * Offoce list
     *
     *
     */
    @Override
    public List<Office> filter(Long orgId, String name,String phone, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);

        Root<Office> officeRoot = criteria.from(Office.class);

        Predicate predicate = builder.conjunction();

        if (orgId != null) {
            Predicate p = builder.equal(officeRoot.get("organization").get("id"), orgId);
            predicate = builder.and(predicate, p);
        }

        if (name != null) {
            Predicate p = builder.equal(officeRoot.get("name"), name);
            predicate = builder.and(predicate, p);
        }

        if (phone != null) {
            Predicate p = builder.equal(officeRoot.get("phone"), phone);
            predicate = builder.and(predicate, p);
        }

        if (isActive != null) {
            Predicate p = builder.equal(officeRoot.get("isActive"), isActive);
            predicate = builder.and(predicate, p);
        }

        criteria.where(predicate);
        TypedQuery<Office> query = em.createQuery(criteria);
        List<Office> office = em.createQuery(criteria).getResultList();

        return office;

    }
}

