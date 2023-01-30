package Soru2.service;

import Soru2.entity.Musteri;
import Soru2.entity.Siparis;
import Soru2.entity.SiparisKalemi;
import Soru2.entity.Urun;
import Soru2.repository.SiparisDao;
import Soru2.util.HibernateUtil;


import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class SiparisService {
    static SiparisDao siparisDao = new SiparisDao();

    public void save(Siparis siparis) {
        try {
            siparisDao.save(siparis);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void update(){
        try {
            Musteri newMusteri= new Musteri("Halil","Kazancı");
            Urun newUrun= new Urun("Yeni Ürün",15000);
            SiparisKalemi newSiparisKalemi= new SiparisKalemi(newUrun,4);
            Siparis newSiparis= new Siparis(newMusteri, Arrays.asList(newSiparisKalemi));
            siparisDao.update(newSiparis);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id){
        try {
            siparisDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


    public void getAll() {
        List<Siparis> siparisList = null;
        siparisList = siparisDao.getAll();
        System.out.println("============================================ÜRÜMLER============================================");
        for (Siparis s : siparisList) {
            Integer siparisToplam = 0;
            System.out.println("\n" +
                    "Sipariş id : " + s.getId() + " Müşteri Ad-Soyad: " + s.getMusteri().getAd() + " " + s.getMusteri().getSoyad() + " " + "Müşteri ID : " + s.getMusteri().getId());

            for (SiparisKalemi sk : s.getSiparisKalemiList()) {
                System.out.println("Urün : " + sk.getUrun().getUrunAdi() + " " + " Fiyat : " + sk.getUrun().getUrunFiyat() + " " + " Adet : " + sk.getAdet());
                siparisToplam = siparisToplam + sk.getUrun().getUrunFiyat() * sk.getAdet();
            }
            System.out.println("Toplam sipariş tutarı : " + siparisToplam);
        }
        System.out.println("===============================================================================================");
    }


    public void soru2C() {
        try {
        siparisDao.soru2C();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
