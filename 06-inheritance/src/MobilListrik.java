/** Subclass tingkat 2 (multilevel): MobilListrik extends Mobil extends Kendaraan. */
public class MobilListrik extends Mobil {
    private int kapasitasBaterai;

    public MobilListrik(String merek, int tahun, int jumlahPintu, int kapasitasBaterai) {
        super(merek, tahun, jumlahPintu);
        this.kapasitasBaterai = kapasitasBaterai;
        System.out.println("  [MobilListrik] constructor");
    }

    @Override
    public void nyalakan() {
        System.out.println("  " + merek + " menyala tanpa suara mesin.");
    }

    @Override
    public String info() {
        return super.info() + ", baterai " + kapasitasBaterai + " kWh";
    }
}
