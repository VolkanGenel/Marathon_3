package com.volkan.repository;

import com.volkan.repository.entity.Arac;
import com.volkan.repository.entity.EntityState;
import com.volkan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AracRepository extends MyFactoryRepository <Arac,Long> {
    public AracRepository() {
        super(new Arac());
    }

    public List<Arac> aracDurumu(EntityState entityState) {
        CriteriaQuery<Arac> criteria = getCriteriaBuilder().createQuery(Arac.class);
        Root<Arac> root = criteria.from(Arac.class);
        criteria.select(root).where(getCriteriaBuilder().equal(root.get("state"),entityState));
        return getEntityManager().createQuery(criteria).getResultList();
    }
}
