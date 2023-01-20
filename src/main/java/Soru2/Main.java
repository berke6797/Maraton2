package Soru2;

import Soru2.entity.Musteri;
import Soru2.entity.Siparis;
import Soru2.entity.SiparisKalemi;
import Soru2.entity.Urun;
import Soru2.repository.SiparisDao;
import Soru2.service.SiparisService;
import Soru2.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static SiparisService siparisService= new SiparisService();


    public static void main(String[] args) {
        Musteri musteri1 = new Musteri("Berke", "Kazancı");
        Musteri musteri2 = new Musteri("Emre", "Kazancı");
        Musteri musteri3 = new Musteri("Dilhan", "Kazancı");

        Urun urun1 = new Urun("Urun1", 2000);
        Urun urun2 = new Urun("Urun2", 2500);
        Urun urun3 = new Urun("Urun3", 3000);
        Urun urun4 = new Urun("Urun4", 5000);

        SiparisKalemi sKalemi1 = new SiparisKalemi(urun1, 2);
        SiparisKalemi sKalemi2 = new SiparisKalemi(urun2, 3);
        SiparisKalemi sKalemi3 = new SiparisKalemi(urun3, 5);

        Siparis siparis1 = new Siparis(musteri1, Arrays.asList(sKalemi1, sKalemi3));
        Siparis siparis2 = new Siparis(musteri2, Arrays.asList(sKalemi1, sKalemi2));
        Siparis siparis3 = new Siparis(musteri3, Arrays.asList(new SiparisKalemi(urun4, 3)));

        // siparisDao.save(siparis1);
        // siparisDao.save(siparis2);
        // siparisDao.save(siparis3);

       siparisService.getAll();
    }
}
