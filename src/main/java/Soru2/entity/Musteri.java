package Soru2.entity;



import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ad;
    private String soyad;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "musteri")
    private List<Siparis> siparisList;

    public Musteri(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }
    public Musteri(int id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }

}
