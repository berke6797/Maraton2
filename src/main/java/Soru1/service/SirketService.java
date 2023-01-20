package Soru1.service;

import Soru1.entity.Sirket;
import Soru1.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SirketService implements ICrud<Sirket>{
    private DB db= new DB();
    List<Sirket> sirketList= new ArrayList<>();
    @Override
    public void create(Sirket sirket) {
        String sql="insert into sirket(isim,sahip,unvan,faaliyetAlani,kurulusYil) values(?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement= db.connection.prepareStatement(sql);
            preparedStatement.setString(1,sirket.getSirtketIsim());
            preparedStatement.setString(2,sirket.getSirketSahibi());
            preparedStatement.setString(3,sirket.getUnvan());
            preparedStatement.setString(4,sirket.getFaaliyetAlani());
            preparedStatement.setInt(5,sirket.getKurulusYil());
            preparedStatement.executeUpdate();
            System.out.println("Şirket eklendi");
        }catch (Exception e){
            System.out.println(e.getMessage());
                e.printStackTrace();
        }
    }

    @Override
    public void read() {
        String sql= "select * from sirket";
        try{
            PreparedStatement preparedStatement= db.connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                Integer sirketId=rs.getInt("id");
                String isim=rs.getString("isim");
                String sirketSahibi= rs.getString("sahip");
                String sirketUnvan=rs.getString("unvan");
                String sirketFaaliyetAlani=rs.getString("faaliyetAlani");
                Integer kurulusYil=rs.getInt("kurulusYil");
                Sirket sirket= new Sirket(sirketId,isim,sirketSahibi,sirketUnvan,sirketFaaliyetAlani,kurulusYil);
                sirketList.add(sirket);
            }
            sirketList.forEach(System.out::println);

        }catch (Exception e) {

         }

    }

    @Override
    public void update(Sirket sirket) {

    }

    @Override
    public void delete(int id) {

    }
}
