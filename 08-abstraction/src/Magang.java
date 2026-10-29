public class Magang extends Karyawan {
    private static final double UANG_SAKU = 1_500_000;

    public Magang(String id, String nama) {
        super(id, nama);
    }

    @Override
    public double hitungGaji() {
        return UANG_SAKU;
    }

    @Override
    public String getJabatan() {
        return "Peserta Magang";
    }

    // Method biasa dari superclass dapat di-override bila perlu.
    @Override
    public void cetakSlip() {
        System.out.println("  (Slip uang saku)");
        super.cetakSlip();
    }
}
