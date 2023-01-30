package Soru2;

import Soru2.entity.Musteri;
import Soru2.entity.Siparis;
import Soru2.entity.SiparisKalemi;
import Soru2.entity.Urun;
import Soru2.repository.SiparisDao;
import Soru2.service.MusteriService;
import Soru2.service.SiparisService;
import Soru2.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static SiparisService siparisService = new SiparisService();
    static  MusteriService musteriService= new MusteriService();

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
        //===================================================================================================================================

        // ----- Sipariş üzerinden  CRUD işlemleri -------------- SORU 2A

        // Burada delete ve update metodları yazılmamıştır ama repo ve service'de bulunmaktadır.
        //  siparisService.save(siparis1);
        //  siparisService.save(siparis2);
        //  siparisService.save(siparis3);
        //  siparisService.getAll();
         // siparisService.update();

        //===================================================================================================================================

        // ----- Müşteri üzerinden  CRUD işlemleri-------------- SORU2B
        // musteriService.save(musteri1);
        // musteriService.save(musteri2);
         // musteriService.getAll();

        //===================================================================================================================================

        // SORU2C--->Bu soru için native query siparisDao'da yazılmıştır. Daha sonrasında siparisService aracılığıyla burada
        // metod çağırılmıştır.

        //siparisService.soru2C();

        //===================================================================================================================================
        // Soru2D ---> Bu soru için native query musteriDao'da yazılmıştır. Daha sonrasında service aracılığıyla burada
        // metod çağırılmıştır.
        //  musteriService.soru2D();

    }
}
