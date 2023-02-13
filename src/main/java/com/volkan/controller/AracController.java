package com.volkan.controller;

import com.volkan.repository.entity.Arac;
import com.volkan.repository.entity.EntityState;
import com.volkan.service.AracService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AracController {
    private Scanner scanner;
    private AracService aracService;

    public AracController() {
    scanner = new Scanner(System.in);
    aracService = new AracService();
    }

    public void aracEkle() {

            System.out.println("");
            System.out.println("***************************");
            System.out.println("****** ARAC EKLEME ******");
            System.out.println("***************************");
            System.out.println();

            System.out.println("Arac marka.....: ");
            String marka = scanner.nextLine();
            System.out.println("Arac model.....: ");
            Long model = Long.parseLong(scanner.nextLine());
            aracService.save(Arac.builder()
                    .marka(marka)
                    .model(model)
                    .state(EntityState.PASSIVE)
                    .createat(System.currentTimeMillis())
                    .updateat(System.currentTimeMillis())
                    .build());
    }


    public Optional<Arac> findById() {
        aracService.findAll().forEach(s -> System.out.println(s.getId() + "-" + s.getMarka()+ "-" + s.getModel()));
        System.out.println("Lütfen arac-idsi giriniz");
        Long id = Long.parseLong(scanner.nextLine());
        return aracService.findById(id);
    }

    public void aracDurumu(EntityState entityState) {
        aracService.aracDurumu(entityState).forEach(x->{
            System.out.println(x.getId()+" - "+ x.getMarka() +" "+ x.getModel() +" - "+ x.getState());
        });
    }
}
