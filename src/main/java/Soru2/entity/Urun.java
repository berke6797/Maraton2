package Soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String urunAdi;
    private int urunFiyat;

    public Urun(int id, String urunAdi, int urunFiyat) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.urunFiyat = urunFiyat;
    }

    public Urun(String urunAdi, int urunFiyat) {
        this.urunAdi = urunAdi;
        this.urunFiyat = urunFiyat;
    }

}
