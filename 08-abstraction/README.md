# 08 - Abstraction (Abstract Class)

## Konsep
Abstraksi menyembunyikan detail pelaksanaan dan hanya menampilkan apa yang perlu diketahui pemakai. Di Java, abstraksi dibuat lewat **abstract class** dan **interface** (folder `09-interface`).

Aturan abstract class:
- Dideklarasikan dengan `abstract class`, tidak dapat diinstansiasi (`new Karyawan(...)` gagal kompilasi).
- Boleh berisi method abstract (tanpa badan) dan method biasa (dengan badan).
- Subclass non-abstract wajib mengimplementasikan semua method abstract.
- Boleh punya atribut, constructor (dipanggil lewat `super(...)` dari subclass), dan member dengan access modifier apa pun.

Contoh memakai pola *template*: `cetakSlip()` di abstract class menyusun format slip dan memanggil `hitungGaji()` serta `getJabatan()` yang diisi subclass.

## Struktur folder
```
08-abstraction/
├── README.md
└── src/
    ├── Karyawan.java         # abstract class
    ├── KaryawanTetap.java    # gaji pokok + tunjangan
    ├── KaryawanKontrak.java  # upah per jam x jam kerja
    ├── Magang.java           # uang saku tetap, meng-override cetakSlip()
    └── Main.java
```

## Cara menjalankan
```bash
cd 08-abstraction
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
  ID      : K-001
  Nama    : Rosyid
  Jabatan : Karyawan Tetap
  Gaji    : Rp7,000,000

  ID      : K-002
  Nama    : Budi
  Jabatan : Karyawan Kontrak (120 jam)
  Gaji    : Rp4,800,000

  (Slip uang saku)
  ID      : K-003
  Nama    : Sari
  Jabatan : Peserta Magang
  Gaji    : Rp1,500,000

Total pengeluaran gaji: Rp13,300,000
```

## Poin yang ditunjukkan
- `new Karyawan("X", "Y")` ditolak compiler: `Karyawan is abstract; cannot be instantiated` (ada sebagai komentar di `Main.java`).
- Format slip ditulis sekali di `Karyawan`. Subclass hanya menentukan cara hitung gaji dan nama jabatan.
- `Magang` meng-override method biasa `cetakSlip()` untuk menambah satu baris, lalu memanggil `super.cetakSlip()`.
- Perulangan bekerja pada tipe `Karyawan[]`, jadi jenis karyawan baru cukup dibuat sebagai subclass baru.

## Abstract class dan interface
| | Abstract class | Interface |
| :--- | :--- | :--- |
| Jumlah yang dapat diwarisi | Satu | Banyak |
| Atribut instans | Boleh | Tidak (hanya konstanta) |
| Constructor | Ada | Tidak ada |
| Dipakai ketika | Subclass berbagi kode dan keadaan | Class yang tidak berkerabat berbagi kemampuan |
