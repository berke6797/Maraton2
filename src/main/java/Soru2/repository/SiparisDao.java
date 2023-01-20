package Soru2.repository;

import Soru2.entity.Siparis;
import Soru2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class SiparisDao implements ICrud<Siparis> {

    @Override
    public void save(Siparis siparis) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(siparis);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    public void update(Siparis siparis) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(siparis);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Siparis> getAll() {
        List<Siparis> list =new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            session.getTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }


}