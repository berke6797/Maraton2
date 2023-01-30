package Soru2.repository;

import Soru2.entity.Siparis;
import Soru2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class SiparisDao implements ICrud<Siparis> {

    Session session = HibernateUtil.getSessionFactory().openSession();
    @Override
    public void save(Siparis siparis) {
        try {
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Siparis> getAll() {
        List<Siparis> list = new ArrayList<>();
        try {
            session.beginTransaction();
            // HQL --> Hibernate Query Language aşağıdaki gibi yazımı vardır
            list=session.createQuery("from Siparis siparis").list();
            // JPQL --> Java persistence query language
            // list = session.createQuery("select siparis from Siparis siparis").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
    @Override
    public void update(Siparis siparis) {
        try {
            session.beginTransaction();
            session.update(siparis);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        Siparis siparis= null;
        try{
            session.getTransaction().begin();
            siparis=session.load(Siparis.class,id);
            session.delete(siparis);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void soru2C(){
        List<Object[]> siparisListesi = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.id , count(Musteri_id) FROM Siparis as s\n" +
                    "inner join Musteri as m on s.musteri_id=m.id\n" +
                    "group by m.id;";
            siparisListesi = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisListesi) {
                System.out.println(
                        " Musteri Id: " + item[0] + " "+
                        " Siparis Sayısı: " + item[1]
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }


}