# 07 - Polymorphism (Polimorfisme)

## Konsep
Polimorfisme berarti satu nama atau satu tipe referensi dapat berperilaku berbeda. Java punya dua bentuk:

| | Overloading | Overriding |
| :--- | :--- | :--- |
| Disebut juga | *Compile-time* / *static* polymorphism | *Runtime* / *dynamic* polymorphism |
| Terjadi pada | Satu class (atau turunannya) | Superclass dan subclass |
| Syarat | Nama sama, daftar parameter berbeda | Tanda tangan method sama persis, tipe kembalian sama atau subtipe |
| Dipilih | Compiler, dari tipe argumen | JVM, dari tipe objek sebenarnya (*dynamic dispatch*) |

Konsep pendukung:
- **Upcasting**: `Bentuk b = new Lingkaran(10);` otomatis, selalu aman.
- **Downcasting**: `(Lingkaran) b` eksplisit. Dikompilasi bila tipenya berhubungan, tetapi bisa melempar `ClassCastException` saat program berjalan. Periksa dulu dengan `instanceof`.
- Lewat referensi `Bentuk`, hanya member yang dideklarasikan di `Bentuk` yang bisa dipanggil. `keliling()` hanya ada di `Lingkaran`, jadi perlu downcast.

## Struktur folder
```
07-polymorphism/
├── README.md
└── src/
    ├── Kalkulator.java   # overloading method tambah(...)
    ├── Bentuk.java       # superclass
    ├── Lingkaran.java    # override luas() dan gambar()
    ├── Persegi.java      # override luas() dan gambar()
    ├── Segitiga.java     # override luas(), memakai gambar() milik Bentuk
    └── Main.java
```

## Cara menjalankan
```bash
cd 07-polymorphism
javac -d bin src/*.java
java -cp bin Main
```

## Contoh keluaran
```
1. Overloading (dipilih saat kompilasi)
  tambah(int, int)        -> 5
  tambah(int, int, int)   -> 9
  tambah(double, double)  -> 6.0
  tambah(String, String)  -> Polimorfisme

2. Overriding (dipilih saat program berjalan)
  Menggambar lingkaran berjari-jari 7.0
  Lingkaran, luas = 153.94
  Menggambar persegi bersisi 4.0
  Persegi, luas = 16.00
  Menggambar bentuk umum
  Segitiga, luas = 15.00
  Total luas = 184.94

3. Upcasting dan downcasting
  Tipe referensi: Bentuk, tipe objek: Lingkaran
  keliling() setelah downcast = 62.83
  Downcast Persegi ke Lingkaran: ClassCastException
```

## Poin yang ditunjukkan
- `tambah(2, 3)` memanggil versi `int`, `tambah(2.5, 3.5)` versi `double`. Pilihan dibuat saat kompilasi.
- Array `Bentuk[]` berisi tiga objek berbeda. Perulangan memanggil `b.luas()` dan `b.gambar()` pada tipe `Bentuk`, tetapi versi yang jalan mengikuti objeknya. Menambah bentuk baru tidak memerlukan perubahan pada perulangan.
- `Segitiga` tidak meng-override `gambar()`, sehingga keluarannya `Menggambar bentuk umum`.
- Downcast `Persegi` ke `Lingkaran` lolos kompilasi dan gagal saat program berjalan dengan `ClassCastException`.
- Field tidak bersifat polimorfik. Hanya method instans yang ditentukan saat runtime.
