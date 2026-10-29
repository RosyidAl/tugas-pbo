public class Lingkaran extends Bentuk {
    private double jariJari;

    public Lingkaran(double jariJari) {
        super("Lingkaran");
        this.jariJari = jariJari;
    }

    @Override
    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    @Override
    public void gambar() {
        System.out.println("  Menggambar lingkaran berjari-jari " + jariJari);
    }

    public double keliling() {
        return 2 * Math.PI * jariJari;
    }
}
