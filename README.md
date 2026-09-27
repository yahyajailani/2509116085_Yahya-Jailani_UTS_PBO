## Nama: Yahya Jailani
## Kelas: C
## NIM: 2509116085
## Mata Kuliah: Pemrograman Berbasis Objek
## Tugas: Ujian Tengah Semester

# SISTEM MANAJEMEN LAUNDRY

## Deskripsi Proyek

Sistem Manajemen Laundry merupakan program berbasis Java yang dibuat untuk membantu proses pengelolaan data pada usaha laundry. Program ini digunakan untuk mengelola data pelanggan, layanan laundry, transaksi, serta status pengerjaan laundry.

Program memiliki beberapa layanan seperti **Cuci Kering, Cuci Setrika, Cuci Selimut, dan Cuci Karpet**. Pengguna dapat menambahkan data pelanggan, melihat data layanan, membuat transaksi, mencari pelanggan, serta memperbarui status laundry.

Sistem juga menerapkan beberapa konsep dasar Pemrograman Berorientasi Objek (OOP), yaitu **Encapsulation, Inheritance, Polymorphism, Method Overriding, Method Overloading, Conditional, Looping, dan ArrayList**. Program disusun menggunakan struktur **Model-View-Controller (MVC)** agar bagian data, proses, dan tampilan program lebih terorganisir.

Program ini dapat digunakan sebagai gambaran sederhana sistem yang dapat diterapkan pada usaha laundry untuk membantu proses pencatatan dan pengelolaan transaksi.

---

# Alur Program

## 1. Menjalankan Program

Program dijalankan melalui class `Main.java`.

Pada saat program dijalankan, `Main` akan membuat objek `LaundryController` dan `LaundryView`. Setelah itu sistem menampilkan menu utama.

```text
========================================
        SISTEM MANAJEMEN LAUNDRY
========================================
1. Data Pelanggan
2. Tambah Pelanggan
3. Data Layanan
4. Buat Transaksi
5. Data Transaksi
6. Update Status Laundry
7. Cari Pelanggan
0. Keluar
========================================
```

Pengguna dapat memilih menu dengan memasukkan angka sesuai pilihan yang tersedia.

---

## 2. Data Pelanggan

Pada menu **Data Pelanggan**, sistem menampilkan seluruh pelanggan yang tersimpan di dalam `ArrayList`.

Informasi yang ditampilkan meliputi:

* ID pelanggan
* Nama pelanggan
* Nomor HP
* Role pelanggan
* Jumlah transaksi

Program juga menyediakan menu **Tambah Pelanggan** untuk memasukkan pelanggan baru.

Setiap input akan divalidasi. ID pelanggan tidak boleh sama, nama tidak boleh kosong, dan nomor HP hanya dapat berisi angka dengan panjang tertentu.

---

## 3. Data Layanan

Menu **Data Layanan** digunakan untuk melihat layanan yang tersedia pada sistem.

Contoh layanan yang tersedia:

* Cuci Kering
* Cuci Setrika
* Cuci Selimut
* Cuci Karpet

Layanan dibagi menjadi dua jenis, yaitu:

```text
Layanan
├── LaundryKiloan
└── LaundrySatuan
```

Laundry kiloan menghitung harga berdasarkan jumlah kilogram, sedangkan laundry satuan menghitung harga berdasarkan jumlah barang.

---

## 4. Membuat Transaksi

Untuk membuat transaksi, pengguna memilih menu **Buat Transaksi**.

Alurnya adalah:

```text
Pilih Pelanggan
       ↓
Pilih Layanan
       ↓
Masukkan Jumlah
       ↓
Masukkan ID Transaksi
       ↓
Sistem Menghitung Harga
       ↓
Sistem Menghitung Diskon
       ↓
Transaksi Disimpan
```

Sistem akan mengambil data pelanggan dan layanan yang sudah tersedia sehingga pengguna tidak perlu memasukkan ulang seluruh data.

Jumlah laundry harus lebih dari 0 dan ID transaksi tidak boleh sama dengan transaksi yang sudah ada.

---

## 5. Perhitungan Harga

Harga transaksi dihitung berdasarkan jenis layanan yang dipilih.

Contohnya jika pelanggan memilih layanan **Cuci Kering** dengan harga Rp7.000/kg dan memasukkan jumlah 8 kg:

```text
7.000 × 8 = Rp56.000
```

Program kemudian memeriksa apakah pelanggan mendapatkan diskon.

Ketentuannya:

```text
Total >= Rp100.000  → Diskon 10%
Total >= Rp50.000   → Diskon 5%
Total < Rp50.000    → Tidak ada diskon
```

Setelah diskon dihitung, sistem menampilkan total pembayaran yang harus dibayar pelanggan.

---

## 6. Melihat Data Transaksi

Menu **Data Transaksi** digunakan untuk melihat seluruh transaksi yang sudah dibuat.

Informasi yang ditampilkan meliputi:

* ID transaksi
* Nama pelanggan
* Nama layanan
* Jumlah laundry
* Harga awal
* Diskon
* Total pembayaran
* Status laundry

Data transaksi disimpan menggunakan `ArrayList<Transaksi>`.

---

## 7. Update Status Laundry

Status transaksi dapat diperbarui melalui menu **Update Status Laundry**.

Pilihan status yang tersedia:

```text
1. Diproses
2. Dicuci
3. Disetrika
4. Selesai
5. Diambil
```

Pengguna memasukkan ID transaksi yang ingin diperbarui, kemudian memilih status baru.

Dengan fitur ini, proses laundry dapat dicatat mulai dari transaksi dibuat sampai laundry selesai dan diambil pelanggan.

---

## 8. Mencari Pelanggan

Program menyediakan dua metode pencarian pelanggan.

### Berdasarkan ID

Sistem menggunakan:

```java
cariPelanggan(String id)
```

Method ini mencari pelanggan berdasarkan ID.

### Berdasarkan Nama dan Nomor HP

Sistem menggunakan:

```java
cariPelanggan(String nama, String noHp)
```

Method ini mencari pelanggan berdasarkan nama dan nomor HP.

Kedua method memiliki nama yang sama tetapi parameter berbeda sehingga menerapkan **Method Overloading**.

---

# Struktur Program

Program menggunakan struktur MVC:

```text
Model
├── Pengguna
├── Admin
├── Pelanggan
├── Layanan
├── LaundryKiloan
├── LaundrySatuan
└── Transaksi

Controller
└── LaundryController

View
└── LaundryView

Main
└── Menjalankan Program
```

<img width="500" alt="image" src="https://github.com/user-attachments/assets/2993725a-ecff-40b1-aed7-3bd90a4c17da" />

### Model

Package `model` digunakan untuk menyimpan class dan data yang digunakan dalam sistem.

### Controller

`LaundryController` digunakan untuk mengatur proses pengelolaan data pelanggan, layanan, dan transaksi.

### View

`LaundryView` digunakan untuk menampilkan menu dan menerima input dari pengguna.

### Main

`Main.java` digunakan sebagai titik awal untuk menjalankan program.

---

# Konsep OOP yang Diterapkan

## Inheritance

Inheritance diterapkan pada dua bagian.

Pertama:

```text
Pengguna
├── Admin
└── Pelanggan
```

Kedua:

```text
Layanan
├── LaundryKiloan
└── LaundrySatuan
```

Dengan inheritance, class turunan dapat menggunakan atribut dan method yang berasal dari class induknya.

## Polymorphism - Method Overriding

Overriding diterapkan pada method seperti:

```java
hitungHarga()
getRole()
tampilkanInfo()
```

Contohnya `LaundryKiloan` dan `LaundrySatuan` memiliki method `hitungHarga()` yang sama, tetapi proses perhitungannya disesuaikan dengan jenis layanan.

## Polymorphism - Method Overloading

Overloading diterapkan pada method:

```java
cariPelanggan(String id)
```

dan:

```java
cariPelanggan(String nama, String noHp)
```

Kedua method memiliki nama yang sama tetapi parameter yang berbeda.

## Encapsulation

Encapsulation diterapkan dengan membuat atribut pada class menggunakan access modifier `private`.

Contohnya:

```java
private String nama;
private String noHp;
```

Akses terhadap data dilakukan melalui getter dan setter.

## Conditional

`if-else` digunakan untuk menentukan kondisi tertentu, seperti:

* Validasi input
* Pemberian diskon
* Pemeriksaan data
* Pemilihan status laundry

## Looping

Looping digunakan untuk:

* Menjalankan menu sampai pengguna memilih keluar
* Menampilkan data dalam `ArrayList`
* Mencari data
* Mengulang input jika data yang diberikan tidak sesuai

---

# Screenshot Output

## 1. Menu Utama

Screenshot pertama menunjukkan **menu utama Sistem Manajemen Laundry**.

<img width="500" alt="image" src="https://github.com/user-attachments/assets/0bb87819-10e5-4468-87dd-ccb7d961545b" />


Pada bagian ini terdapat beberapa pilihan untuk mengelola pelanggan, layanan, transaksi, status laundry, dan pencarian pelanggan.

---

## 2. Data Pelanggan

<img width="500" alt="image" src="https://github.com/user-attachments/assets/8f0f3186-e6c7-49b8-a2b7-6fb489924a05" />


Pada gambar ini menunjukkan data pelanggan yang tersimpan di dalam sistem. Data yang ditampilkan terdiri dari ID, nama, nomor HP, role, dan jumlah transaksi.

---

## 3. Data Layanan

<img width="500" alt="image" src="https://github.com/user-attachments/assets/a0c1bf44-273e-4dcb-96b1-ddf3e47f1c8b" />

Data layanan ini menunjukkan layanan laundry yang tersedia beserta jenis satuan dan harga layanan.

Layanan kiloan menggunakan satuan kilogram, sedangkan layanan satuan menggunakan jumlah barang.

---

## 4. Pembuatan Transaksi

<img width="500" alt="image" src="https://github.com/user-attachments/assets/eb90baba-d033-42bc-9708-63b56d95c334" />


pada gambar ini menunjukkan proses pembuatan transaksi. Admin memilih pelanggan, memilih layanan, memasukkan jumlah laundry, kemudian sistem menghitung harga transaksi secara otomatis.

---

## 5. Hasil Perhitungan

<img width="500" alt="image" src="https://github.com/user-attachments/assets/142dde88-b44b-4905-8dac-74279222b9fe" />


pada tahap ini menunjukkan hasil transaksi setelah sistem menghitung harga awal, diskon, dan total pembayaran.

---

## 6. Update Status

<img width="500" alt="image" src="https://github.com/user-attachments/assets/7aefdfe1-1a55-4ac9-8340-a7efa358b740" />

Tahap terakhir ini menunjukkan proses perubahan status laundry. Status dapat diubah mulai dari **Diproses, Dicuci, Disetrika, Selesai, hingga Diambil**.
