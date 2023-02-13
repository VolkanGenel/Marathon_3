package com.volkan.service;


import com.volkan.repository.KisiRepository;
import com.volkan.repository.entity.Kisi;
import com.volkan.utility.MyFactoryService;

public class KisiService  extends MyFactoryService<KisiRepository, Kisi, Long> {
    public KisiService() {

        super(new KisiRepository());
    }
}
