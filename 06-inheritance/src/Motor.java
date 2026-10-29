/** Subclass lain dari Kendaraan (hierarchical inheritance). */
public class Motor extends Kendaraan {
    private boolean adaBoncengan;

    public Motor(String merek, int tahun, boolean adaBoncengan) {
        super(merek, tahun);
        this.adaBoncengan = adaBoncengan;
        System.out.println("  [Motor] constructor");
    }

    public void wheelie() {
        System.out.println("  " + merek + " mengangkat roda depan.");
    }

    @Override
    public String info() {
        return super.info() + (adaBoncengan ? ", bisa boncengan" : ", satu penumpang");
    }
}
