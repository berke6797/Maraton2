package Soru2.repository;

import Soru2.entity.Musteri;
import Soru2.entity.Siparis;
import Soru2.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class MusteriDao implements ICrud<Musteri> {

    Session session = HibernateUtil.getSessionFactory().openSession();
    @Override
    public void save(Musteri musteri) {
        try {
            session.beginTransaction();
            session.save(musteri);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Musteri musteri) {
        try {
            session.beginTransaction();
            session.update(musteri);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        Musteri musteri= null;
        try{
            session.getTransaction().begin();
            musteri=session.load(Musteri.class,id);
            session.delete(musteri);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Musteri> getAll() {
        List<Musteri> musteriList= new ArrayList<>();
        try {
            session.beginTransaction();
            // HQL query
            musteriList=session.createQuery("from Musteri musteri").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return musteriList;
    }

    public void soru2D() {
        List<Object[]> siparisList = null;
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "SELECT m.ad,m.soyad,s.id as siparis_no  FROM Musteri as m \n" +
                    "inner join Siparis as s on s.musteri_id=m.id";
            siparisList = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : siparisList) {
                System.out.println(
                        " Müşteri'nin Adı ve Soyadı : " + item[0] + " "+ item[1] +" "
                        + " Sipariş numarası: " + item[2]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


}
