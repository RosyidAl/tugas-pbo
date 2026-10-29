# 06 - Inheritance (Pewarisan)

## Konsep
Inheritance membuat class baru (*subclass*) yang mewarisi atribut dan method dari class lain (*superclass*) dengan keyword `extends`. Hubungannya *is-a*: `Mobil` adalah `Kendaraan`.

Hal yang dicontohkan:
- **Single dan multilevel inheritance**: `MobilListrik` -> `Mobil` -> `Kendaraan`.
- **Hierarchical inheritance**: `Mobil` dan `Motor` sama-sama turunan `Kendaraan`.
- **`super(...)`**: memanggil constructor superclass. Harus menjadi baris pertama constructor. Jika tidak ditulis, compiler menyisipkan `super()`, sehingga superclass perlu punya constructor tanpa parameter.
- **`super.metode()`**: memanggil versi superclass dari method yang di-override.
- **Overriding** dengan `@Override`: subclass mengganti implementasi method. Anotasi membuat compiler memeriksa bahwa method memang ada di superclass.
- **`final` pada method**: `jenisInduk()` tidak dapat di-override.
- **`protected`**: atribut `merek` dan `tahun` terlihat oleh subclass.

Java hanya mengizinkan satu superclass langsung per class. Untuk menggabungkan beberapa kontrak dipakai interface (folder `09-interface`).

## Struktur folder
```
06-inheritance/
├── README.md
└── src/
    ├── Kendaraan.java      # superclass
    ├── Mobil.java          # extends Kendaraan
    ├── MobilListrik.java   # extends Mobil (level kedua)
    ├── Motor.java          # extends Kendaraan
    └── Main.java
```

## Cara menjalankan
```bash
cd 06-inheritance
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
1. Urutan constructor pada multilevel inheritance
  [Kendaraan] constructor: Hyundai Ioniq
  [Mobil] constructor
  [MobilListrik] constructor

2. Method warisan, override, dan super
  Hyundai Ioniq menyala tanpa suara mesin.
  Bagasi Hyundai Ioniq terbuka.
  Hyundai Ioniq (2024), 4 pintu, baterai 72 kWh
  jenisInduk(): Kendaraan

3. Subclass lain dari superclass yang sama
  [Kendaraan] constructor: Honda Vario
  [Motor] constructor
  Honda Vario menyala.
  Honda Vario mengangkat roda depan.
  Honda Vario (2022), bisa boncengan

4. Hubungan is-a dengan instanceof
  k instanceof MobilListrik: true
  k instanceof Mobil       : true
  k instanceof Kendaraan   : true
  k instanceof Motor       : false
```

## Poin yang ditunjukkan
- Constructor dijalankan dari superclass paling atas ke bawah: `Kendaraan`, `Mobil`, `MobilListrik`.
- `ev.info()` mengikuti rantai `super.info()` dari `MobilListrik` ke `Mobil` ke `Kendaraan`, tiap level menambahkan informasinya.
- `motor.nyalakan()` memakai versi `Kendaraan` karena `Motor` tidak meng-override-nya.
- `ev instanceof Motor` tidak bisa dikompilasi karena kedua tipe tidak berada dalam satu garis pewarisan. Pengujian dilakukan lewat variabel bertipe `Kendaraan`, dan hasilnya `false`.
