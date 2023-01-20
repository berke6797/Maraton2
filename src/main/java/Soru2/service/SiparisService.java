package Soru2.service;

import Soru2.entity.Siparis;
import Soru2.entity.SiparisKalemi;
import Soru2.repository.SiparisDao;
import Soru2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SiparisService {
   static SiparisDao siparisDao=new SiparisDao();

    public static  void save(Siparis siparis){
        try{
            siparisDao.save(siparis);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void  getAll() {
       List<Siparis> siparisList=siparisDao.getAll();
       for (Siparis s:siparisList){
           System.out.println(
                   "Sipariş id : "+ s.getId()+" "+s.getMusteri().getAd()+" "+s.getMusteri().getSoyad()+" "+ "Müşteri ID : "+s.getMusteri().getId()+"\n"
           );
           Integer siparisToplam=0;
           for (SiparisKalemi sk : s.getSiparisKalemiList()){
               System.out.println(
                 "Urün : "+sk.getUrun().getUrunAdi()+" "+" Fiyat : "+ sk.getUrun().getUrunFiyat()+" "+" Adet : "+sk.getAdet());
               siparisToplam= siparisToplam+sk.getUrun().getUrunFiyat()* sk.getAdet();
           }
           System.out.println("Toplam sipariş tutarı : "+ siparisToplam);
       }

    }

}
