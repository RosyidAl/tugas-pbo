public class Main {
    public static void main(String[] args) {
        // Instansiasi: membuat dua objek dari class yang sama.
        Mahasiswa mhs1 = new Mahasiswa();
        mhs1.nama = "Rosyid";
        mhs1.nim = "L0125065";
        mhs1.ipk = 3.72;

        Mahasiswa mhs2 = new Mahasiswa();
        mhs2.nama = "Budi";
        mhs2.nim = "L0125001";
        mhs2.ipk = 3.10;

        // Setiap objek menyimpan nilai atributnya sendiri.
        mhs1.perkenalan();
        mhs2.perkenalan();
        System.out.println(mhs1.nama + " lulus syarat beasiswa? " + mhs1.lulusSyaratBeasiswa());
        System.out.println(mhs2.nama + " lulus syarat beasiswa? " + mhs2.lulusSyaratBeasiswa());

        // Variabel bertipe class menyimpan referensi, bukan salinan objek.
        Mahasiswa mhs3 = mhs1;
        mhs3.nama = "Rosyid Al Ansorri";
        System.out.println("mhs1.nama setelah mhs3.nama diubah: " + mhs1.nama);
        System.out.println("mhs1 == mhs3 (referensi sama)? " + (mhs1 == mhs3));
        System.out.println("mhs1 == mhs2 (referensi sama)? " + (mhs1 == mhs2));

        // Objek yang belum dibuat bernilai null.
        Mahasiswa kosong = null;
        System.out.println("kosong == null? " + (kosong == null));
    }
}
