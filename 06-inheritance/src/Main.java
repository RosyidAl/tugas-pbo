public class Main {
    public static void main(String[] args) {
        System.out.println("1. Urutan constructor pada multilevel inheritance");
        MobilListrik ev = new MobilListrik("Hyundai Ioniq", 2024, 4, 72);

        System.out.println("\n2. Method warisan, override, dan super");
        ev.nyalakan();             // override di MobilListrik
        ev.bukaBagasi();           // diwarisi dari Mobil
        System.out.println("  " + ev.info());     // rantai super.info() sampai Kendaraan
        System.out.println("  jenisInduk(): " + ev.jenisInduk());   // final, diwarisi apa adanya

        System.out.println("\n3. Subclass lain dari superclass yang sama");
        Motor motor = new Motor("Honda Vario", 2022, true);
        motor.nyalakan();          // versi Kendaraan, tidak di-override
        motor.wheelie();
        System.out.println("  " + motor.info());

        System.out.println("\n4. Hubungan is-a dengan instanceof");
        Kendaraan k = ev;   // upcasting: MobilListrik adalah Kendaraan
        System.out.println("  k instanceof MobilListrik: " + (k instanceof MobilListrik));
        System.out.println("  k instanceof Mobil       : " + (k instanceof Mobil));
        System.out.println("  k instanceof Kendaraan   : " + (k instanceof Kendaraan));
        System.out.println("  k instanceof Motor       : " + (k instanceof Motor));
        // ev instanceof Motor tidak dikompilasi: MobilListrik dan Motor tidak berhubungan.
    }
}
