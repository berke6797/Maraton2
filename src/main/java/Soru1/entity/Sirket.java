package Soru1.entity;

public class Sirket {
    private int sirketId;
    private String sirtketIsim;
    private String sirketSahibi;
    private String unvan;
    private String faaliyetAlani;
    private int kurulusYil;

    public Sirket(String sirtketIsim, String sirketSahibi, String unvan, String faaliyetAlani, int kurulusYil) {
        this.sirtketIsim = sirtketIsim;
        this.sirketSahibi = sirketSahibi;
        this.unvan = unvan;
        this.faaliyetAlani = faaliyetAlani;
        this.kurulusYil = kurulusYil;
    }

    public Sirket(int sirketId, String sirtketIsim, String sirketSahibi, String unvan, String faaliyetAlani, int kurulusYil) {
        this.sirketId = sirketId;
        this.sirtketIsim = sirtketIsim;
        this.sirketSahibi = sirketSahibi;
        this.unvan = unvan;
        this.faaliyetAlani = faaliyetAlani;
        this.kurulusYil = kurulusYil;
    }

    public Sirket(int sirketId) {
        this.sirketId = sirketId;
    }

    public Sirket(int sirketId, String sirtketIsim) {
        this.sirketId = sirketId;
        this.sirtketIsim = sirtketIsim;
    }

    public int getSirketId() {
        return sirketId;
    }

    public void setSirketId(int sirketId) {
        this.sirketId = sirketId;
    }

    public String getSirtketIsim() {
        return sirtketIsim;
    }

    public void setSirtketIsim(String sirtketIsim) {
        this.sirtketIsim = sirtketIsim;
    }

    public String getSirketSahibi() {
        return sirketSahibi;
    }

    public void setSirketSahibi(String sirketSahibi) {
        this.sirketSahibi = sirketSahibi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getFaaliyetAlani() {
        return faaliyetAlani;
    }

    public void setFaaliyetAlani(String faaliyetAlani) {
        this.faaliyetAlani = faaliyetAlani;
    }

    public int getKurulusYil() {
        return kurulusYil;
    }

    public void setKurulusYil(int kurulusYil) {
        this.kurulusYil = kurulusYil;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "sirketId=" + sirketId +
                ", sirtketIsim='" + sirtketIsim + '\'' +
                ", sirketSahibi='" + sirketSahibi + '\'' +
                ", unvan='" + unvan + '\'' +
                ", faaliyetAlani='" + faaliyetAlani + '\'' +
                ", kurulusYil=" + kurulusYil +
                '}';
    }
}
