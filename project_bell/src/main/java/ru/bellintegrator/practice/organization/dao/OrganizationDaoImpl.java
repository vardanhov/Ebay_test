package ru.bellintegrator.practice.organization.dao;



import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class OrganizationDaoImpl implements OrganizationDao {
    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * Update Organization
     *
     *
     */
    @Override
    public void update(OrganizationView update) {
        Organization organization = em.find(Organization.class, update.getId());
        if (organization == null) {
            throw new NullPointerException("Нет такая организация");
        }

        organization.setName(update.getName());
        organization.setFullName(update.getFullName());
        organization.setInn(update.getInn());
        organization.setKpp(update.getKpp());
        organization.setAddress(update.getAddress());
        organization.setPhone(update.getPhone());
        organization.setActive(update.isActive());
        em.merge(organization);
    }



    /**
     * Get Organization by id
     *
     *
     */
    @Override
    public OrganizationView getById(Long id) {
        Organization organization = em.find(Organization.class, id);
        if (organization==null)
            throw new IllegalArgumentException("Организация не найдена");

        OrganizationView view = new OrganizationView();
        view.setId(organization.getId()) ;
        view.setName(organization.getName());
        view.setFullName(organization.getFullName());
        view.setInn(organization.getInn());
        view.setKpp(organization.getKpp());
        view.setAddress(organization.getAddress());
        view.setPhone(organization.getPhone());
        view.setActive(organization.getActive());
        return view;

    }


    /**
     * Save Organization
     *
     *
     */
    @Override
    public void save(OrganizationView view) {

        Organization organization = new Organization();
        organization.setName(view.getName());
        organization.setFullName(view.getFullName());
        organization.setInn(view.getInn());
        organization.setKpp(view.getKpp());
        organization.setAddress(view.getAddress());
        organization.setPhone(view.getPhone());
        organization.setActive(view.isActive());
        em.persist(organization);

    }


    /**
     * Delete Organization
     *
     *
     */
    @Override
    public void delete(Long id) {
        Organization organization = em.find(Organization.class, id);

            em.remove(organization);
        }


    /**
     * Organizatin list
     *
     *
     */
    @Override
    public List<Organization> filter(String name,String inn, Boolean isActive) {
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
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }
}
