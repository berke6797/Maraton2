package Soru1;

import Soru1.entity.Calisan;
import Soru1.entity.Sirket;
import Soru1.service.CalisanService;
import Soru1.service.SirketService;
import Soru1.util.DB;

public class Main {
    static CalisanService calisanService = new CalisanService();
    static SirketService sirketService = new SirketService();

    public static void main(String[] args) {
        Calisan calisan1 = new Calisan("Calisan1", 24, 20000, "Departman1", new Sirket(1));
        Calisan calisan2 = new Calisan("Calisan2", 25, 20000, "Departman2", new Sirket(1));
        Calisan calisan3 = new Calisan("Calisan3", 28, 24000, "Departman3", new Sirket(2));
        Calisan calisan4 = new Calisan("Calisan4", 28, 28000, "Departman4", new Sirket(3));
        Sirket sirket1 = new Sirket("KOÇ", "Vehbi Koç", "LTD", "Teknoloji", 1900);
        Sirket sirket2 = new Sirket("OPET", " Berke Kazancı", "LTD", "Petrol", 1930);
        Sirket sirket3 = new Sirket("Havelsan", " Emre Kazancı", "LTD", "Savunma Sanayi", 1990);
        Sirket sirket4 = new Sirket("Aselsan", "Dilhan Kazancı", "LTD", "Savunma Sanayi", 1998);
        // sirketService.create(sirket4);
        // sirketService.read();
        // calisanService.create(calisan4);
        // calisanService.read();
        // ==============================================================================================
        // Calisan calisan5 = new Calisan(3,"GüncelCalisan3", 30, 4000, "GüncelDepartman3", new Sirket(2));
        // calisanService.update(calisan5);
        // calisanService.delete(4);
    }

}
