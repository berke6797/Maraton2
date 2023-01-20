package Soru1.service;

import Soru1.entity.Calisan;
import Soru1.entity.Sirket;
import Soru1.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CalisanService implements ICrud<Calisan> {
    DB db = new DB();
    List<Calisan> calisanList = new ArrayList<>();

    @Override
    public void create(Calisan calisan) {
        try {
            String sql = "insert into calisan(isim,yas,maas,departman,sirketId) values(?,?,?,?,?)";
            try {
                PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
                preparedStatement.setString(1, calisan.getIsim());
                preparedStatement.setInt(2, calisan.getYas());
                preparedStatement.setInt(3, calisan.getMaas());
                preparedStatement.setString(4, calisan.getDepartman());
                preparedStatement.setInt(5, calisan.getSirket().getSirketId());
                preparedStatement.executeUpdate();
                System.out.println("Çalışan eklendi");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void read() {
        String sql = "select c.id, c.isim, c.yas,c.maas,c.departman, s.id,s.isim from calisan as c inner join sirket as s on c.sirketId=s.id";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Integer calisanId = rs.getInt("id");
                String calisanIsim = rs.getString("isim");
                Integer calisanYas = rs.getInt("yas");
                Integer calisanMaas = rs.getInt("maas");
                String calisanDepartman = rs.getString("departman");
                Integer sirketId = rs.getInt("id");
                String sirketName = rs.getString("isim");
                Calisan calisan = new Calisan(calisanId, calisanIsim, calisanYas, calisanMaas, calisanDepartman, new Sirket(sirketId, sirketName));
                calisanList.add(calisan);
            }
            calisanList.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void update(Calisan calisan) {
        String sql = "update calisan set isim=?, yas=?, maas=?, departman=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getIsim());
            preparedStatement.setInt(2, calisan.getYas());
            preparedStatement.setInt(3, calisan.getMaas());
            preparedStatement.setString(4, calisan.getDepartman());
            preparedStatement.setInt(5, calisan.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql="delete  from calisan where id = ?";
        try {
            PreparedStatement preparedStatement= db.connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate() ;

        } catch (Exception e) {
        e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
