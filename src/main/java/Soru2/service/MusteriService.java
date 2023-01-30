package Soru2.service;

import Soru2.entity.Musteri;
import Soru2.entity.Siparis;
import Soru2.entity.SiparisKalemi;
import Soru2.repository.MusteriDao;
import Soru2.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class MusteriService {

    static MusteriDao musteriDao = new MusteriDao();

    public  void save(Musteri musteri) {
        try {
            musteriDao.save(musteri);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

// ====================================================================================================================
    public void getAll(){
        List<Musteri> musteriList = musteriDao.getAll();
        for (Musteri m : musteriList) {
            System.out.println("Musteri id:" + m.getId() + " Musteri'nin adı soyadı :" + m.getAd() +" "+m.getSoyad() );
            for (Siparis s : m.getSiparisList()) {
                System.out.println("Siparis Id:" + s.getId());
                int siparisToplam = 0;
                int urunFiyat = 0;
                for (SiparisKalemi sk :  s.getSiparisKalemiList()) {
                    System.out.println("Urun:" + sk.getUrun().getUrunAdi() + " Fiyat:" + sk.getUrun().getUrunFiyat() +" Alınan Urun Adedi:"+ sk.getAdet());
                    urunFiyat = sk.getUrun().getUrunFiyat();
                    siparisToplam = siparisToplam + (urunFiyat * sk.getAdet());
                }
                System.out.println("Toplam Harcama:"+siparisToplam);
            }
        }
    }
// ====================================================================================================================

    public void soru2D() {

        try {
            musteriDao.soru2D();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
