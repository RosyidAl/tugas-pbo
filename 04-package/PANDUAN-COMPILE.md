# Panduan Compile dan Menjalankan Program Ber-package

Panduan ini melengkapi [README.md](README.md). Fokusnya cara mengompilasi, menjalankan, dan memakai ulang class yang berada di dalam package. Perintah diuji dengan JDK 25 di Linux. Perintah Windows mengikuti sintaks Command Prompt dan PowerShell tetapi tidak diuji di mesin ini.

## 0. Apa itu folder `bin`?

`bin` hanyalah nama folder untuk menyimpan **hasil compile**. Folder ini tidak ditulis oleh Anda dan bukan bagian dari Java. `javac` yang membuatnya ketika diberi opsi `-d bin`.

### Mengapa perlu hasil compile?

Berkas `.java` ditulis untuk dibaca manusia. JVM (program `java`) tidak bisa menjalankannya langsung. `javac` mengubahnya menjadi berkas `.class` berisi *bytecode*, dan hanya berkas `.class` yang dijalankan oleh `java`.

```
FormatRupiah.java  ──── javac ────►  FormatRupiah.class  ──── java ────►  tampil di layar
(teks, dibaca manusia)               (biner, dibaca JVM)
330 byte                             485 byte
```

Isi berkas `.class` adalah data biner. Empat byte pertamanya selalu `ca fe ba be`, tanda pengenal format class Java.

### Sebelum dan sesudah compile

Sebelum `javac` dijalankan, hanya ada `src`:

```
04-package/
└── src/
    └── id/rosyidalansorri/
        ├── app/Main.java
        ├── gudang/Barang.java
        ├── toko/Barang.java
        └── util/FormatRupiah.java
```

Setelah `javac -d bin $(find src -name "*.java")`, muncul folder `bin`, sedangkan `src` tidak berubah (tetap 4 berkas):

```
04-package/
├── src/                                  ◄── tulisan Anda, tidak disentuh
│   └── id/rosyidalansorri/ ... (4 berkas .java)
└── bin/                                  ◄── baru, dibuat oleh javac
    └── id/rosyidalansorri/
        ├── app/Main.class
        ├── gudang/Barang.class
        ├── toko/Barang.class
        └── util/FormatRupiah.class
```

Satu `.java` menjadi satu `.class`, dengan jalur folder yang sama persis di bawah `bin`.

### Kata `bin` muncul tiga kali, artinya berbeda

| Perintah | Arti `bin` di situ | Dibaca sebagai |
| :--- | :--- | :--- |
| `javac -d bin ...` | Folder **tujuan** tempat `.class` ditulis | "Taruh hasil compile di folder bin." |
| `java -cp bin ...` | Folder tempat JVM **mencari** class saat program jalan | "Cari class di folder bin." |
| `jar ... -C bin .` | Folder **sumber** isi arsip JAR | "Masuk ke folder bin, masukkan semua isinya." |

Alurnya: `-d bin` menulis ke `bin`, lalu `-cp bin` membaca dari `bin`. Kalau dua nilai ini berbeda, program tidak ketemu class-nya.

### Hal yang bisa dicoba

Percobaan berikut dijalankan di mesin ini, hasilnya tertulis di samping.

| Langkah | Hasil |
| :--- | :--- |
| Ubah teks `Rp` menjadi `IDR` di `FormatRupiah.java`, lalu langsung `java -cp bin ...` | Masih tampil `Rp1,250,000`. JVM membaca `.class` lama, bukan `.java`. |
| Compile ulang dengan `javac -d bin ...`, lalu jalankan lagi | Tampil `IDR 1,250,000`. Setiap kali source diubah, compile ulang dulu. |
| Hapus folder `bin`, lalu `java -cp bin ...` | `Error: Could not find or load main class ...`. Tidak ada yang rusak, `bin` tinggal dibuat lagi dengan `javac`. |
| Ganti `-d bin` dan `-cp bin` menjadi `-d hasil` dan `-cp hasil` | Berjalan normal. Nama folder bebas, asalkan sama di kedua perintah. |

### Mengapa `bin` terpisah dari `src`, dan tidak di-commit ke Git

- Source dan hasil compile tidak bercampur. Tanpa `-d`, `javac` menaruh `.class` di sebelah `.java` (lihat bagian 8), dan folder `src` menjadi berantakan.
- `bin` selalu bisa dibuat ulang dari `src`, jadi aman dihapus kapan saja.
- Karena itu `bin/` dan `*.class` ada di `.gitignore` repo ini. Yang disimpan di GitHub hanya `src`. Siapa pun yang meng-clone repo menjalankan `javac` sendiri.

### Nama lain yang sering ditemui

`bin` dipakai oleh Eclipse dan VS Code. IntelliJ IDEA biasanya memakai `out`, Maven memakai `target/classes`, Gradle memakai `build/classes`. Fungsinya sama, hanya nama foldernya berbeda. Pada panduan ini dipakai `bin` karena sama dengan `.gitignore` repo.

## 1. Tiga aturan dasar

1. **Package sama dengan folder.** Baris `package id.rosyidalansorri.util;` mengharuskan berkas berada di `.../id/rosyidalansorri/util/`. Titik pada nama package menjadi pemisah folder.
2. **Classpath menunjuk ke akar package, bukan ke folder package.** Untuk class `id.rosyidalansorri.util.FormatRupiah`, classpath harus berisi folder yang di dalamnya ada `id/`. Pada proyek ini akarnya adalah `src` (untuk source) dan `bin` (untuk hasil compile).
3. **Class dijalankan dengan nama lengkap.** Perintahnya `java -cp bin id.rosyidalansorri.app.Main`, bukan `java Main` dan bukan `java app.Main`.

## 2. Alur kerja

```
src/                                   javac -d bin ...                  bin/
└── id/rosyidalansorri/            ─────────────────────────►            └── id/rosyidalansorri/
    ├── app/Main.java                  (struktur folder dibuatkan            ├── app/Main.class
    ├── gudang/Barang.java              otomatis oleh javac)                 ├── gudang/Barang.class
    ├── toko/Barang.java                                                     ├── toko/Barang.class
    └── util/FormatRupiah.java                                               └── util/FormatRupiah.class
                                                                                      │
                                       java -cp bin id.rosyidalansorri.app.Main ◄─────┘
```

## 3. Cara A: compile semua berkas sekaligus

Dari folder `04-package`:

**Linux atau macOS**
```bash
javac -d bin $(find src -name "*.java")
java -cp bin id.rosyidalansorri.app.Main
```

**Windows Command Prompt**
```bat
dir /s /b src\*.java > sources.txt
javac -d bin @sources.txt
java -cp bin id.rosyidalansorri.app.Main
```

**Windows PowerShell**
```powershell
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName
java -cp bin id.rosyidalansorri.app.Main
```

Arti opsi:

| Opsi | Fungsi |
| :--- | :--- |
| `-d bin` | Folder tujuan file `.class`. `javac` membuat subfolder sesuai nama package. Folder `bin` dibuat bila belum ada. |
| `-cp bin` (`-classpath`) | Daftar lokasi tempat JVM mencari class. Tanpa opsi ini, JVM hanya mencari di folder saat ini (`.`). |
| `@sources.txt` | Membaca daftar berkas dari file. Dipakai di Windows karena Command Prompt tidak punya `find`. |

Folder `bin/` sudah ada di `.gitignore` repo ini, jadi hasil compile tidak ikut ter-commit.

## 4. Cara B: hanya compile `Main`, dependensi dicari otomatis

```bash
javac -sourcepath src -d bin src/id/rosyidalansorri/app/Main.java
```

`-sourcepath src` memberi tahu `javac` tempat mencari source class yang di-import. Class yang dibutuhkan (`gudang.Barang`, `toko.Barang`, `util.FormatRupiah`) ikut dikompilasi. Hasil uji: keempat file `.class` muncul di `bin`.

Cara ini mengompilasi hanya class yang dipakai. Class yang tidak direferensikan dari `Main` tidak ikut dikompilasi.

## 5. Cara C: compile bertahap per package

Berguna untuk memahami bahwa package yang dipakai harus sudah ada saat package lain dikompilasi. Urutan mengikuti ketergantungan:

```bash
javac -d bin src/id/rosyidalansorri/util/*.java
javac -cp bin -d bin src/id/rosyidalansorri/gudang/*.java src/id/rosyidalansorri/toko/*.java
javac -cp bin -d bin src/id/rosyidalansorri/app/*.java
java -cp bin id.rosyidalansorri.app.Main
```

Pada langkah kedua dan ketiga, `-cp bin` dibutuhkan agar `javac` menemukan class hasil langkah sebelumnya. Perhatikan bahwa `toko.Barang` memakai `util.FormatRupiah`, jadi `util` harus lebih dulu.

## 6. Membuat file JAR

JAR adalah arsip ZIP berisi class dengan struktur folder package yang sama.

```bash
jar --create --file app.jar --main-class id.rosyidalansorri.app.Main -C bin .
java -jar app.jar
```

- `-C bin .` berarti pindah ke folder `bin`, lalu masukkan seluruh isinya. Karena itu isi JAR dimulai dari `id/...`, tanpa awalan `bin/`.
- `--main-class` menulis nama class utama ke `META-INF/MANIFEST.MF` supaya `java -jar` tahu class mana yang dijalankan.
- Isi arsip dapat dilihat dengan `jar tf app.jar`.

## 7. Memakai package dari program lain

Misalkan hanya package `util` yang dijadikan pustaka:

```bash
jar --create --file lib/util.jar -C bin id/rosyidalansorri/util
```

Program lain (`Klien.java`, tanpa package) memakainya:

```java
import id.rosyidalansorri.util.FormatRupiah;

public class Klien {
    public static void main(String[] args) {
        System.out.println(FormatRupiah.format(75_000));
    }
}
```

JAR harus ada di classpath **saat compile dan saat run**:

```bash
javac -cp lib/util.jar -d klien-bin klien/Klien.java
java  -cp lib/util.jar:klien-bin Klien        # Linux/macOS
java  -cp "lib\util.jar;klien-bin" Klien      # Windows
```

Pemisah beberapa lokasi di classpath adalah `:` di Linux dan macOS, `;` di Windows. Keluaran pada uji: `Rp75,000`.

Hanya class yang `public` dan member yang `public` yang bisa dipakai dari luar package (lihat folder `05-access-modifier`). Class `FormatRupiah` dan method `format` sudah `public` untuk keperluan ini.

## 8. Error yang sering muncul

Pesan di bawah adalah keluaran `javac` dan `java` dari JDK 25 pada percobaan di mesin ini.

| Gejala | Penyebab | Perbaikan |
| :--- | :--- | :--- |
| `Error: Could not find or load main class Main` `Caused by: java.lang.ClassNotFoundException: Main` | Class berada di dalam package tetapi dijalankan dengan nama pendek. | Pakai nama lengkap: `java -cp bin id.rosyidalansorri.app.Main`. |
| `Error: Could not find or load main class id.rosyidalansorri.app.Main` | Opsi `-cp bin` terlupa, sehingga JVM mencari di folder saat ini. Penyebab lain: program dijalankan dari folder yang salah. | Tambahkan `-cp bin`, atau jalankan dari folder yang berisi `bin`. |
| `error: package id.rosyidalansorri.gudang does not exist` | `Main.java` dikompilasi sendirian tanpa `-sourcepath` dan tanpa `-cp` yang berisi class hasil compile. | Pakai Cara A, B, atau C di atas. |
| `error: cannot find symbol` pada `Barang dariGudang = ...` | Baris `import id.rosyidalansorri.gudang.Barang;` terlupa. | Tambahkan `import`, atau tulis nama lengkap class. |
| `error: a type with the same simple name is already defined by the single-type-import of Barang` | Dua class bernama sama di-import sekaligus. | Import salah satu saja, yang lain dipakai dengan nama lengkap. |
| `error: cannot access FormatRupiah ... bad source file ... file does not contain class id.rosyidalansorri.util.FormatRupiah` | Deklarasi `package` di berkas tidak cocok dengan foldernya (misal `package ...utils;` di folder `util`). | Samakan deklarasi `package` dengan letak folder. |
| Tidak ada error compile, tetapi `Could not find or load main class` saat run | Deklarasi `package` tidak cocok dengan foldernya, dan semua berkas dikompilasi dengan `-d bin`. `javac` menaruh class sesuai deklarasi `package` (`bin/.../apps/Main.class`), bukan sesuai folder source. | Samakan deklarasi `package`, nama folder, dan nama yang dipakai saat `java`. |
| File `.class` muncul di sebelah file `.java` di `src/` | `javac` dijalankan tanpa `-d`. | Selalu pakai `-d bin` agar source dan hasil compile terpisah. |
| `NoClassDefFoundError: id/rosyidalansorri/util/FormatRupiah` saat run | Compile berhasil karena JAR ada di classpath, tetapi saat `java` dijalankan JAR tidak disertakan. | Sertakan JAR di `-cp` saat `java` juga. |

## 9. Catatan untuk IDE

IntelliJ IDEA, Eclipse, dan VS Code (Extension Pack for Java) perlu tahu folder mana yang menjadi akar source. Untuk repo ini, pilih `04-package/src` sebagai *source root*. Jika memilih `04-package` sendiri, IDE menganggap package-nya `src.id.rosyidalansorri...` dan melaporkan deklarasi `package` tidak cocok dengan lokasi berkas.

## 10. Daftar periksa

- [ ] Deklarasi `package` di tiap berkas sama dengan jalur foldernya di bawah `src/`.
- [ ] Compile dengan `-d bin`, dari folder yang sama dengan `src/` dan `bin/`.
- [ ] Class dan member yang dipakai lintas package berstatus `public`.
- [ ] Jalankan dengan `-cp bin` dan nama class lengkap.
- [ ] Bila memakai JAR, sertakan di `-cp` pada compile dan run.
