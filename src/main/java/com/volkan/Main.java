package com.volkan;

import com.volkan.controller.AracController;
import com.volkan.controller.KiralamaController;
import com.volkan.controller.KisiController;
import com.volkan.repository.entity.Kisi;
import com.volkan.service.KisiService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int secim;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("****************************");
            System.out.println("**** ARAC KİRALAMA UYGULAMASI ****");
            System.out.println("****************************");
            System.out.println();
            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Arama");
            System.out.println("3- Kisi Ekleme");
            System.out.println("4- Kiralama Yap");
            System.out.println("5- Raporlamalar");
            System.out.println("0- Çıkış Yap");
            System.out.println("Seçiniz....: ");
            secim = scanner.nextInt();
            switch (secim) {
                case 1: new AracController().aracEkle(); break;
                case 2: System.out.println(new AracController().findById().get()); break;
                case 3: new KisiController().kisiEkle(); break;
                case 4: new KiralamaController().kiralamaYap(); break;
                case 5: new KiralamaController().raporlamaYap(); break;
            }
        } while (secim != 0);
        System.out.println("Tekrar Görüşmek Üzere");


    }

}