package com.volkan.controller;

import com.volkan.repository.entity.Arac;
import com.volkan.repository.entity.EntityState;
import com.volkan.repository.entity.Kiralama;
import com.volkan.service.AracService;
import com.volkan.service.KiralamaService;
import com.volkan.service.KisiService;

import java.util.Scanner;

public class KiralamaController {
    private Scanner scanner;
    private KiralamaService kiralamaService;
    private AracService aracService;
    private KisiService kisiService;

    public KiralamaController() {
        scanner = new Scanner(System.in);
        kiralamaService = new KiralamaService();
        aracService = new AracService();
        kisiService = new KisiService();
    }

    public void kiralamaYap() {
        System.out.println("");
        System.out.println("***************************");
        System.out.println("****** KIRALAMA YAP ******");
        System.out.println("***************************");
        System.out.println();

        System.out.println("Arac idsi.....: ");
        Long aracid = Long.parseLong(scanner.nextLine());
        System.out.println("Kisi idsi.....: ");
        Long kisiid = Long.parseLong(scanner.nextLine());
        kiralamaService.save(Kiralama.builder()
                        .aracid(aracid)
                        .kisiid(kisiid)
                .state(EntityState.ACTIVE)
                .createat(System.currentTimeMillis())
                .updateat(System.currentTimeMillis())
                .build());

        Arac arac = aracService.findById(aracid).get();
        arac.setState(EntityState.ACTIVE);
        aracService.update(arac);

    }

    public void raporlamaYap() {
        int secim;
        do {
            System.out.println("****************************");
            System.out.println("**** RAPORLAMALAR ****");
            System.out.println("****************************");
            System.out.println();
            System.out.println("1- Kirada Olan Araçlar");
            System.out.println("2- Boşta Olan Araçlar");
            System.out.println("3- Herhangi Bir Müşterinin Kiraladığı Araçlar");
            System.out.println("0- Geri Dön");
            System.out.println("Seçiniz....: ");
            secim = new Scanner(System.in).nextInt();
            switch (secim) {
                case 0 :
                    System.out.println("Alt Menuye Donuluyor");
                case 1:
                    new AracController().aracDurumu(EntityState.ACTIVE);
                    break;
                case 2:
                    new AracController().aracDurumu(EntityState.PASSIVE);
                    break;
                case 3:
                    System.out.println("Lütfen Kişi ID si giriniz");
                    new KiralamaService().kisininAraclari(new Scanner(System.in).nextLong()).forEach(x->{
                            System.out.println(x);
                        System.out.println(new AracService().findById(x.getAracid()).get());
                    });
                    break;
            }
        } while (secim != 0);
    }

}
