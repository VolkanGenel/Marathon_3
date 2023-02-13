package com.volkan.repository;

import com.volkan.repository.entity.Kisi;
import com.volkan.utility.MyFactoryRepository;

public class KisiRepository extends MyFactoryRepository<Kisi,Long> {
    public KisiRepository() {
        super(new Kisi());
    }
}
