public class Main {
    public static void main(String[] args) {
        System.out.println("1. Constructor tanpa parameter");
        Buku a = new Buku();
        a.tampilkan();

        System.out.println("\n2. Constructor dua parameter (chaining ke constructor lengkap)");
        Buku b = new Buku("Pemrograman Java", "Rosyid");
        b.tampilkan();

        System.out.println("\n3. Constructor lengkap");
        Buku c = new Buku("Struktur Data", "Budi", 2021, 85_000.0);
        c.tampilkan();

        System.out.println("\n4. Copy constructor");
        Buku salinan = new Buku(c);
        salinan.setJudul("Struktur Data (Salinan)");
        System.out.print("  asli   :");
        c.tampilkan();
        System.out.print("  salinan:");
        salinan.tampilkan();
    }
}
