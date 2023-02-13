package com.volkan.controller;

import com.volkan.repository.entity.Arac;
import com.volkan.repository.entity.EntityState;
import com.volkan.repository.entity.Kisi;
import com.volkan.service.KisiService;
import java.util.Scanner;

public class KisiController {
    private Scanner scanner;
    private KisiService kisiService;
    public KisiController() {
        scanner = new Scanner(System.in);
        kisiService = new KisiService();
    }

    public void kisiEkle() {
        System.out.println("");
        System.out.println("***************************");
        System.out.println("****** KISI EKLEME ******");
        System.out.println("***************************");
        System.out.println();

        System.out.println("Kisi adi.....: ");
        String name = scanner.nextLine();
        System.out.println("Kisi soyadi.....: ");
        String surname = scanner.nextLine();
        kisiService.save(Kisi.builder()
                        .name(name)
                        .surname(surname)
                .state(EntityState.PASSIVE)
                .createat(System.currentTimeMillis())
                .updateat(System.currentTimeMillis())
                .build());
    }
}
