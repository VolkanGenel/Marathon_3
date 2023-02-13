package com.volkan.service;

import com.volkan.repository.KiralamaRepository;
import com.volkan.repository.entity.Kiralama;
import com.volkan.utility.MyFactoryService;

import java.util.List;
import java.util.Scanner;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama, Long> {
    public KiralamaService() {
        super(new KiralamaRepository());
    }


    public List<Kiralama> kisininAraclari(Long id) {
        return getRepository().kisininAraclari(id);
    }
}
