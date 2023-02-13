package com.volkan.service;

import com.volkan.repository.AracRepository;
import com.volkan.repository.entity.Arac;
import com.volkan.repository.entity.EntityState;
import com.volkan.utility.MyFactoryService;

import java.util.List;

public class AracService extends MyFactoryService<AracRepository, Arac, Long> {
    public AracService() {
        super(new AracRepository());
    }

    public List<Arac> aracDurumu(EntityState entityState) {
        return getRepository().aracDurumu(entityState);
    }
}
