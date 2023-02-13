package com.volkan.repository;

import com.volkan.repository.entity.Kiralama;
import com.volkan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class KiralamaRepository extends MyFactoryRepository<Kiralama,Long> {

    public KiralamaRepository() {
        super(new Kiralama());
    }


    public List<Kiralama> kisininAraclari(Long columnValue) {
        CriteriaQuery<Kiralama> criteria = getCriteriaBuilder().createQuery(Kiralama.class);
        Root<Kiralama> root = criteria.from(Kiralama.class);
        criteria.select(root);
        criteria.where(getCriteriaBuilder().equal(root.get("kisiid"),columnValue));
        List<Kiralama> result = getEntityManager().createQuery(criteria).getResultList();
        return result;
    }
}
