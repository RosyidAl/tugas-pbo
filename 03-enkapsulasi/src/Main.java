public class Main {
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa("L0125065", "Rosyid", 3.6);
        System.out.println(mhs.getNim() + " | " + mhs.getNama() + " | " + mhs.getIpk()
                + " | " + mhs.getPredikat());

        System.out.println("\nSetter dengan nilai valid:");
        mhs.setIpk(3.2);
        System.out.println("  IPK sekarang " + mhs.getIpk() + ", predikat " + mhs.getPredikat());

        System.out.println("\nSetter dengan nilai tidak valid:");
        mhs.setIpk(5.0);
        mhs.setNama("   ");
        System.out.println("  IPK tetap " + mhs.getIpk() + ", nama tetap " + mhs.getNama());

        // Baris di bawah tidak bisa dikompilasi karena atributnya private:
        // mhs.ipk = 9.9;       // error: ipk has private access in Mahasiswa
        // mhs.setNim("X");     // error: tidak ada method setNim
    }
}
