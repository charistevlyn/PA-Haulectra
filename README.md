 <div align="center">

# HAULECTRA ── ⟡
<img width="500" height="200" alt="IMG_7212" src="https://github.com/user-attachments/assets/6578945e-0150-40e2-8ba8-2fa129eaf09d" />



</div>


## ↳ Deskripsi Singkat 
Haulectra adalah aplikasi toko online yang membantu pemilik toko mengelola jualannya di satu tempat, sekaligus memudahkan pelanggan berbelanja tanpa harus datang ke toko. Pelanggan bisa melihat katalog produk, memasukkan barang ke keranjang, memakai voucher diskon, memilih metode pembayaran, dan melacak pesanannya sampai paket tiba. Sementara itu, admin toko bisa mengelola produk dan stok, mengatur promo, memantau pesanan dan pengiriman, serta melihat data pelanggan

## ↳ Fitur Utama Program <br>
### Pelanggan
| Fitur | Penjelasan |
|---|---|
| Login | Masuk menggunakan username dan password. Sistem memeriksa akun dan mengarahkan pengguna sesuai perannya. |
| Registrasi akun | Membuat akun baru dengan mengisi data yang diperlukan kemmudian sistem akan memvalidasi data dan memastikan username belum digunakan. |
| Melihat beranda | Menampilkan halaman utama sebagai akses ke katalog, keranjang, riwayat pesanan, dan profil. |
| Melihat katalog produk | Menampilkan seluruh produk yang tersedia beserta informasinya. |
| Mencari & memfilter produk | Mencari produk berdasarkan nama dan menyaring produk berdasarkan kategori. |
| Melihat keranjang belanja | Menampilkan daftar produk yang telah dipilih sebelum pembelian. |
| Mengelola keranjang | Menambah, mengubah jumlah, atau menghapus produk kemudian sistem akan menyesuaikan jumlah dengan stok tersedia. |
| Checkout & pembayaran | Menampilkan ringkasan belanja, menghitung total, menyimpan pesanan dan pembayaran, serta mengurangi stok produk. |
| Memilih metode pembayaran | Memilih metode pembayaran melalui transfer atau e-wallet. |
| Membuat pesanan | Menyimpan data pesanan beserta rincian produk dalam satu transaksi. |
| Memasukkan kode voucher | Memasukkan voucher secara opsional. Sistem memeriksa kode, minimal jumlah barang, dan masa berlaku sebelum memberikan diskon. |
| Melihat riwayat pesanan | Menampilkan seluruh pesanan yang pernah dilakukan oleh pelanggan. |
| Membatalkan pesanan | Membatalkan pesanan dengan mengubah statusnya menjadi Pesanan Dibatalkan. |
| Melacak pesanan | Menampilkan nomor resi, perkiraan tanggal tiba, dan status pengiriman. |
| Mengonfirmasi barang diterima | Mengonfirmasi penerimaan barang sehingga status pengiriman berubah menjadi Diterima. |
| Melihat profil | Menampilkan nama, username, alamat, dan nomor telepon pelanggan. |
| Mengubah data identitas | Memperbarui informasi pribadi, termasuk alamat tujuan pengiriman. |
| Logout | Mengakhiri sesi dan kembali ke halaman login. |

### Admin
| Fitur | Penjelasan |
|---|---|
| Login | Masuk melalui halaman login dan diarahkan ke dashboard admin sesuai perannya. |
| Melihat dashboard | Menampilkan ringkasan aktivitas aplikasi serta akses ke menu produk, promo, pesanan, pengiriman, dan pelanggan. |
| Melihat daftar produk | Menampilkan produk beserta nama, kategori, harga, dan stok. |
| Menambah produk | Menambahkan produk baru dengan mengisi data yang divalidasi sebelum disimpan. |
| Mengubah produk | Memilih produk dan memperbarui informasi produknya. |
| Menghapus produk | Menghapus produk setelah memberikan konfirmasi. |
| Melihat daftar promo | Menampilkan seluruh voucher atau promo yang telah dibuat. |
| Menambah promo | Membuat voucher dengan mengisi kode, jenis dan besar diskon, minimal jumlah barang, serta tanggal berlaku. |
| Mengubah promo | Memperbarui informasi voucher yang tersedia. |
| Menghapus promo | Menghapus voucher setelah memberikan konfirmasi. |
| Melihat detail resi pengiriman | Menampilkan daftar pengiriman beserta informasi resinya. |
| Mengatur status pengiriman | Memperbarui status pengiriman. Nomor resi dibuat otomatis saat pesanan dikirim. |
| Melihat daftar pesanan | Menampilkan seluruh pesanan pelanggan serta memperbarui status pesanan dan mengonfirmasi pembayaran secara manual. |
| Melihat data pelanggan | Menampilkan daftar pelanggan yang telah terdaftar tanpa fitur pengubahan data. |
| Logout | Mengakhiri sesi admin dan kembali ke halaman login. |

## ↳ Tech Stack

## ↳ Perancangan Sistem
### Flowchart
**Login**
<details>
 <summary>1. Flowchart Menu login</summary>
  <img width="600" height="497" alt="Capston-Menu Login drawio (2)" src="https://github.com/user-attachments/assets/584ee523-f9c7-4313-a13c-e035515e1d8c" />
</details>

**Admin**
<details>
  <summary>1. Flowchart Menu Admin</summary>
  <img width="877" height="387" alt="Capston-Menu Admin drawio (1)" src="https://github.com/user-attachments/assets/e33ba98d-3635-4981-9c24-a1b57a000e3c" />
</details>

<details>
  <summary>2. Flowchart Menu Admin Kelola Produk</summary>
  <img width="1016" height="562" alt="Capston-Menu Admin_Kelola Produk drawio" src="https://github.com/user-attachments/assets/1892a15a-fbe3-4cb2-93d6-1107841cb8d8" />
</details>

<details>
  <summary>3. Flowchart Menu Admin Kelola Promo</summary>
<img width="1082" height="617" alt="Capston-Menu Admin_Kelola Promo drawio" src="https://github.com/user-attachments/assets/8894371d-1db0-42c8-95cd-ccecbf29e433" />
</details>

<details>
  <summary>4. Flowchart Menu Admin Kelola Pengiriman</summary>
  <img width="800" height=600" alt="Capston-Menu Admin_Kelola Pengiriman drawio" src="https://github.com/user-attachments/assets/d3d9ab37-dcb8-467c-a5aa-b44ea46b6915" />
</details>

<details>
  <summary>5. Flowchart Menu Admin Kelola Pesanan</summary>
  <img width="700" height="650" alt="Capston-Menu Admin_Kelola Pesanan drawio" src="https://github.com/user-attachments/assets/75d2e3d0-c881-4472-9824-f3e9a3720cd5" />
</details>

<details>
  <summary>6. Flowchart Menu Admin Kelola Pelanggan</summary>
 <img width="557" height="700" alt="Capston-Menu Admin_Kelola Data pelanggan drawio" src="https://github.com/user-attachments/assets/ceb74f6c-6563-4cd7-965b-3ea525139465" />
</details>

**Pelanggan**
<details>
  <summary>1. Flowchart Menu Pelanggan</summary>
 <img width="900" height="462" alt="Capston-Menu Pelanggan  drawio" src="https://github.com/user-attachments/assets/9a83b75e-14f5-4d7e-b9ba-f24908a8793e" />
</details>

<details>
  <summary>2. Flowchart Menu Pelanggan Katalog Produk</summary>
 <img width="1543" height="1227" alt="Capston-Menu Pelanggan_Katalog Produk drawio" src="https://github.com/user-attachments/assets/4eb9b5be-1848-49ed-8401-be325c15723a" />
</details>

<details>
  <summary>3. Flowchart Menu Pelanggan Keranjang Belanja</summary>
 <img width="1358" height="1292" alt="Capston-Menu Pelanggan_Keranjang Belanja drawio" src="https://github.com/user-attachments/assets/ad5c7f73-54ad-4bab-9fa1-88c86657ec52" />
</details>

<details>
  <summary>4. Flowchart Menu Pelanggan Riwayat Pesanan</summary>
<img width="538" height="1000" alt="Capston-Menu Pelanggan_Riwayat Pesanan drawio" src="https://github.com/user-attachments/assets/200b1282-5f9f-4a1f-a4a8-8d10e997fcb8" />
</details>

<details>
  <summary>5. Flowchart Menu Pelanggan Lacak Pesanan </summary>
<img width="534" height="982" alt="Capston-Menu Pelanggan_Lacak Pesanan drawio" src="https://github.com/user-attachments/assets/4ae8e6f5-0e0b-4a47-94c8-468b451fec9d" />
</details>

<details>
  <summary>6. Flowchart Menu Pelanggan Profil </summary>
<img width="727" height="1000" alt="Capston-Menu Pelanggan_Profil drawio" src="https://github.com/user-attachments/assets/411c0707-1c68-4fcc-a9dd-02d947490cdf" />
</details>

## ↳ Struktur Program/Package

## ↳ 4 Pilar OOP

## ↳ Alur Program

## ↳ Anggota Kelompok 1

1. Alif Anugrah Ramadhan [2509116019]
2. Syavira Firnanda Prawiro [2509116072]
3. Hanif Amelia Putri [2509116075]
4. Charist Evlyn Myscha Rerung [2509116102]

