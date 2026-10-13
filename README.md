# Tugas Praktikum Pemrograman Berorientasi Objek (PBO)
## Demonstrasi Penggunaan Access Modifier melalui Sistem Rekening Bank

---

### 👤 Identitas Mahasiswa
- **Nama**  : Rosyid Al Ansorri
- **NIM**   : L0125065
- **Kelas** : Praktikum PBO D
- **Repo**  : [git@github.com:RosyidAl/tugas-pbo.git](https://github.com/RosyidAl/tugas-pbo)

---

## 📌 Deskripsi Tugas
Tugas ini mempraktikkan konsep **Access Modifier** dan **Encapsulation** pada bahasa pemrograman Java melalui simulasi sistem perbankan.

Sistem terdiri dari:
1. **Package Dasar (`id.rosyidalansorri`)**:
   - `Rekening`: Class dasar akun perbankan yang memiliki atribut `namaPemilik` dan `saldo` berkategori **`private`**, atribut `kodeCabang` berkategori **`default` (package-private)**, method `terapkanBunga()` dan `infoInternalRekening()` berkategori **`protected`**, serta constructor, getter, dan method operasional `setor()` & `tarik()` berkategori **`public`**. Saldo rekening dienkapsulasi secara ketat dan hanya dapat berubah melalui method `setor()` dan `tarik()`.
   - `PetugasBank`: Class dalam package yang sama yang mendemonstrasikan akses langsung terhadap atribut **`default`** (`kodeCabang`).
2. **Package Prioritas (`id.rosyidalansorri.prioritas`)**:
   - `RekeningPrioritas`: Class turunan (*subclass*) dari `Rekening` yang berada di package berbeda, mendemonstrasikan hak akses method **`protected`** yang diwariskan dari superclass.
3. **Package Aplikasi (`id.rosyidalansorri.app`)**:
   - `Main`: Entry point program yang membuat instance objek dan mendemonstrasikan pemanggilan method/atribut lintas package serta membuktikan batasan akses yang diizinkan dan tidak diizinkan.

---

## 📂 Struktur Direktori Proyek

```
tugas-pbo/
├── bin/                                        # Direktori bytecode (.class) hasil kompilasi
├── src/
│   └── id/
│       └── rosyidalansorri/                    # Package dasar (<tld>.<nama>)
│           ├── Rekening.java                   # Class Rekening (private, default, protected, public)
│           ├── PetugasBank.java                # Class PetugasBank (demonstrasi akses default se-package)
│           ├── prioritas/                      # Subpackage .prioritas
│           │   └── RekeningPrioritas.java      # Subclass Rekening (demonstrasi akses protected)
│           └── app/                            # Subpackage .app
│               └── Main.java                   # Entry point aplikasi & pengujian data
├── README.md
└── PPBOD_04_L0125065_RosyidAlAnsorri.zip       # Berkas arsip pengumpulan tugas
```

---

## 🔐 Matriks Hak Akses Modifier di Java

| Modifier | Class yang Sama (*Same Class*) | Package yang Sama (*Same Package*) | Subclass Beda Package (*Diff Package Subclass*) | Dimanapun (*World / Diff Package*) |
| :--- | :---: | :---: | :---: | :---: |
| **`public`** | ✅ Ya | ✅ Ya | ✅ Ya | ✅ Ya |
| **`protected`** | ✅ Ya | ✅ Ya | ✅ Ya | ❌ Tidak |
| **`default`** *(no modifier)* | ✅ Ya | ✅ Ya | ❌ Tidak | ❌ Tidak |
| **`private`** | ✅ Ya | ❌ Tidak | ❌ Tidak | ❌ Tidak |

---

## 🔍 Pembuktian Akses Diizinkan vs Tidak Diizinkan

### 1. `public`
- **Diizinkan**: Objek `Rekening` dapat diinstansiasi dari class `Main` yang berada di package `id.rosyidalansorri.app`. Method `setor()`, `tarik()`, dan getter dapat dipanggil secara bebas lintas package.
  ```java
  Rekening rek = new Rekening("Rosyid Al Ansorri", 1500000.0, "CABANG-SOLO-01");
  rek.setor(500000.0);
  rek.tarik(250000.0);
  ```

### 2. `default` (Package-Private)
- **Diizinkan**: Class `PetugasBank` berada pada package yang sama (`id.rosyidalansorri`), sehingga dapat langsung membaca dan mengubah nilai `rek.kodeCabang`.
  ```java
  // Di dalam class PetugasBank (package id.rosyidalansorri)
  rek.kodeCabang = "CABANG-SOLO-VIP"; // BERHASIL
  ```
- **Ditolak (Compile Error)**: Class `Main` (package `id.rosyidalansorri.app`) atau subclass `RekeningPrioritas` (package `id.rosyidalansorri.prioritas`) tidak dapat mengakses `rek.kodeCabang`.
  ```java
  // Di dalam Main.java atau RekeningPrioritas.java
  rek.kodeCabang = "CABANG-BARU";
  // ERROR COMPILE: kodeCabang is not public in id.rosyidalansorri.Rekening; cannot be accessed from outside package
  ```

### 3. `protected`
- **Diizinkan**: Subclass `RekeningPrioritas` di package `id.rosyidalansorri.prioritas` dapat memanggil method `super.terapkanBunga()` dan `super.infoInternalRekening()`.
  ```java
  // Di dalam class RekeningPrioritas (subclass)
  super.terapkanBunga(persen); // BERHASIL
  ```
- **Ditolak (Compile Error)**: Class `Main` yang berada di luar package dan bukan turunan class `Rekening` tidak dapat memanggil method protected tersebut.
  ```java
  // Di dalam Main.java
  rekReguler.terapkanBunga(5.0);
  // ERROR COMPILE: terapkanBunga(double) has protected access in id.rosyidalansorri.Rekening
  ```

### 4. `private`
- **Diizinkan**: Hanya method di dalam class `Rekening` yang berhak mengubah `saldo` dan `namaPemilik`.
- **Ditolak (Compile Error)**: Mengakses atau mengubah saldo secara langsung dari luar class `Rekening` tidak diizinkan sama sekali demi menjaga integritas data (prinsip Enkapsulasi).
  ```java
  // Di dalam class manapun di luar Rekening
  rek.saldo = 100000000;
  // ERROR COMPILE: saldo has private access in id.rosyidalansorri.Rekening
  ```

---

## 🚀 Panduan Kompilasi dan Menjalankan Program

### 1. Kompilasi Semua Source Code
Buka terminal pada direktori root proyek (`tugas-pbo`), lalu jalankan:

```bash
javac -d bin src/id/rosyidalansorri/*.java src/id/rosyidalansorri/prioritas/*.java src/id/rosyidalansorri/app/*.java
```

### 2. Jalankan Program
Eksekusi class `Main` dengan menyertakan classpath ke direktori `bin`:

```bash
java -cp bin id.rosyidalansorri.app.Main
```

---

## 🖥️ Contoh Output Program

```text
╔══════════════════════════════════════════════════════════════════════════════╗
║            PRAKTIKUM PEMROGRAMAN BERORIENTASI OBJEK (PBO)                    ║
║                DEMONSTRASI JAVA ACCESS MODIFIER                              ║
╠══════════════════════════════════════════════════════════════════════════════╣
║ Nama  : Rosyid Al Ansorri                                                    ║
║ NIM   : L0125065                                                             ║
║ Topik : Access Modifier (public, protected, default, private)                ║
║ Paket : id.rosyidalansorri, .prioritas, .app                                 ║
╚══════════════════════════════════════════════════════════════════════════════╝

================================================================================
1. DEMONSTRASI ACCESS MODIFIER: PUBLIC
================================================================================
Keterangan: Elemen public dapat diakses bebas dari package manapun.
Di sini, class Main (package .app) mengakses class Rekening (package dasar).

[SUKSES] Objek Rekening berhasil dibuat melalui public constructor:
  - Nama Pemilik (public getter) : Rosyid Al Ansorri
  - Saldo Awal   (public getter) : Rp1,500,000.00
  - Kode Cabang  (public getter) : CABANG-SOLO-01

Menguji transaksi rekening via public method setor() dan tarik():
[SETOR BERHASIL] Rekening Rosyid Al Ansorri (+Rp500,000.00) -> Saldo Sekarang: Rp2,000,000.00
[TARIK BERHASIL] Rekening Rosyid Al Ansorri (-Rp250,000.00) -> Sisa Saldo: Rp1,750,000.00
Saldo akhir setelah transaksi : Rp1,750,000.00

================================================================================
2. DEMONSTRASI ACCESS MODIFIER: DEFAULT (PACKAGE-PRIVATE)
================================================================================
Keterangan: Atribut 'kodeCabang' pada class Rekening tidak memiliki modifier (default).
- Class PetugasBank (satu package id.rosyidalansorri) DAPAT mengaksesnya langsung.
- Class Main (package id.rosyidalansorri.app) TIDAK DAPAT mengaksesnya langsung.

Petugas terdaftar: Ahmad Fauzi (PETUGAS-007)

--- [DEMO DEFAULT MODIFIER - DALAM SATU PACKAGE] ---
Petugas Ahmad Fauzi (PETUGAS-007) sedang memperbarui kode cabang nasabah Rosyid Al Ansorri...
[SUKSES] Akses atribut default 'kodeCabang' berhasil: CABANG-SOLO-01 -> CABANG-SOLO-VIP
Verifikasi dari Main via getter: Kode Cabang sekarang = CABANG-SOLO-VIP

[PEMBUKTIAN AKSES DITOLAK PADA DEFAULT]:
Jika Main mencoba membaca/menulis atribut default 'kodeCabang' secara langsung:
  -> rekReguler.kodeCabang = "CABANG-BARU";
  -> HASIL: COMPILE ERROR! "kodeCabang is not public in id.rosyidalansorri.Rekening; cannot be accessed from outside package"

================================================================================
3. DEMONSTRASI ACCESS MODIFIER: PROTECTED
================================================================================
Keterangan: Method 'terapkanBunga()' dan 'infoInternalRekening()' bersifat protected.
- Subclass RekeningPrioritas (di package .prioritas) BISA memanggilnya via super.
- Class Main (package .app, non-subclass) TIDAK BISA memanggilnya secara langsung.


--- [DEMO PROTECTED METHOD - INFO INTERNAL] ---
Memanggil super.infoInternalRekening() dari subclass:
[PROTECTED - INFO INTERNAL] Pemilik: Siti Nurhaliza | Saldo: Rp10,000,000.00 | Cabang: CABANG-SOLO-VIP
Tingkat Layanan: Platinum Priority | Batas Overdraft: Rp25,000,000.00

--- [DEMO PROTECTED MODIFIER - SUBCLASS BEDA PACKAGE] ---
Nasabah Prioritas (Platinum) menerima bunga bulanan spesial...
[PROTECTED - BUNGA] Menerapkan bunga 3.50% (+Rp350,000.00) ke rekening Siti Nurhaliza -> Saldo Baru: Rp10,350,000.00

[PEMBUKTIAN AKSES DITOLAK PADA PROTECTED]:
Jika class Main memanggil method protected secara langsung pada objek rekening:
  -> rekReguler.terapkanBunga(5.0);
  -> rekPrioritas.terapkanBunga(5.0);
  -> HASIL: COMPILE ERROR! "terapkanBunga(double) has protected access in id.rosyidalansorri.Rekening"

================================================================================
4. DEMONSTRASI ACCESS MODIFIER: PRIVATE & ENKAPSULASI
================================================================================
Keterangan: Atribut 'saldo' dan 'namaPemilik' bersifat private di Rekening.
Tidak ada class lain (Main, PetugasBank, RekeningPrioritas) yang bisa mengaksesnya langsung.

[UJI VALIDASI ENKAPSULASI]:
Mencoba melakukan penarikan ilegal (melebihi saldo yang ada):
[TARIK DITOLAK] Saldo tidak mencukupi! Saldo saat ini: Rp1,750,000.00, Permintaan: Rp50,000,000.00
Status transaksi tarik ilegal: Ditolak (Saldo tetap aman: Rp1,750,000.00)

[PEMBUKTIAN AKSES DITOLAK PADA PRIVATE]:
Jika class Main mencoba memanipulasi saldo secara langsung:
  -> rekReguler.saldo = 999_999_999.0;
  -> rekReguler.namaPemilik = "Hacker";
  -> HASIL: COMPILE ERROR! "saldo has private access in id.rosyidalansorri.Rekening"
Saldo hanya dapat diubah melalui validasi method setor() dan tarik().

================================================================================
5. DOKUMENTASI BARIS KODE ILEGAL (COMPILATION ERROR AUDIT)
================================================================================
[STATUS] Seluruh baris ilegal telah dipetakan dan diverifikasi sesuai aturan JLS (Java Language Specification).

================================================================================
6. RINGKASAN MATRIKS HAK AKSES ACCESS MODIFIER JAVA
================================================================================
+-------------+---------------+---------------+--------------------+---------------+
| Modifier    | Same Class    | Same Package  | Subclass (Diff Pkg)| World/Anywhere|
+-------------+---------------+---------------+--------------------+---------------+
| public      |      YA       |      YA       |         YA         |      YA       |
| protected   |      YA       |      YA       |         YA         |     TIDAK     |
| default     |      YA       |      YA       |        TIDAK       |     TIDAK     |
| private     |      YA       |     TIDAK     |        TIDAK       |     TIDAK     |
+-------------+---------------+---------------+--------------------+---------------+
[SELESAI] Demonstrasi seluruh Access Modifier berhasil dijalankan dengan sempurna.
```
