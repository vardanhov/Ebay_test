package com.practice.organization.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.practice.organization.model.Organization;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class OrganizationDaoImpl implements OrganizationDao {



    @Autowired
    private EntityManager em;




    /**
     * Update Organization
     *
     *
     */
    @Override
    public void update(Organization update) {

        em.merge(update);
    }



    /**
     * Get Organization by id
     *
     *
     */
    @Override
    public Organization getById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization==null)
            throw new IllegalArgumentException("Организация не найдена");

        return organization;

    }


    /**
     * Save Organization
     *
     *
     */
    @Override
    public void save(Organization org) {


        em.persist(org);

    }


    /**
     * Organizatin list
     *
     *
     */
    @Override
    public List<Organization> filter(String name, String inn, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organizationRoot = criteria.from(Organization.class);

        Predicate predicate = builder.conjunction();
        if (name != null) {
            Predicate p = builder.equal(organizationRoot.get("name"), name);
            predicate = builder.and(predicate, p);
        }

        if (inn != null) {
            Predicate p = builder.equal(organizationRoot.get("inn"), inn);
            predicate = builder.and(predicate, p);
        }

        if (isActive != null) {
            Predicate p = builder.equal(organizationRoot.get("isActive"), isActive);
            predicate = builder.and(predicate, p);
        }

        criteria.where(predicate);

        TypedQuery<Organization> query = em.createQuery(criteria);


        List<Organization> organizations = em.createQuery(criteria).getResultList();

        return organizations;

    }
    @Override
    public void delete(Long id) {
        Organization org = em.find(Organization.class, id);
        em.remove(org);

    }
}
