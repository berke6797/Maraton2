package Soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @ManyToOne(cascade = CascadeType.ALL)
    private Musteri musteri;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SiparisKalemi> siparisKalemiList;

    public Siparis (int id, Musteri musteri, List<SiparisKalemi> siparisKalemiList) {
        this.id = id;
        this.musteri = musteri;
        this.siparisKalemiList = siparisKalemiList;
    }

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemiList) {
        this.musteri = musteri;
        this.siparisKalemiList = siparisKalemiList;
    }

}
