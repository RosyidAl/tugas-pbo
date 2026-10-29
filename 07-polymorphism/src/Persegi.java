public class Persegi extends Bentuk {
    private double sisi;

    public Persegi(double sisi) {
        super("Persegi");
        this.sisi = sisi;
    }

    @Override
    public double luas() {
        return sisi * sisi;
    }

    @Override
    public void gambar() {
        System.out.println("  Menggambar persegi bersisi " + sisi);
    }
}
