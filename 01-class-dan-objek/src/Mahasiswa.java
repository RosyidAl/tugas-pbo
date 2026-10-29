/**
 * Class Mahasiswa adalah cetak biru (blueprint) untuk objek mahasiswa.
 * Class mendefinisikan atribut (data) dan method (perilaku).
 * Objek adalah hasil instansiasi class dengan keyword new.
 */
public class Mahasiswa {
    // Atribut (field): data yang dimiliki setiap objek.
    String nama;
    String nim;
    double ipk;

    // Method: perilaku yang dapat dilakukan objek.
    void perkenalan() {
        System.out.println("Halo, saya " + nama + " (NIM " + nim + ")");
    }

    boolean lulusSyaratBeasiswa() {
        return ipk >= 3.5;
    }
}
