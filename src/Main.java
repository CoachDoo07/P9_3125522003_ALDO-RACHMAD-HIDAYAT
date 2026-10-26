public class Main {
    public static void main(String[] args) {
 
        System.out.println("=== 1. Membuat Kos dan Kamar (overloading tambahKamar) ===");
        Kos kos = new Kos("Kos Sejahtera");
        Kamar k01 = new Kamar("K01", "Single", 500000);
        kos.tambahKamar(k01);                          // overload 1: object Kamar
        kos.tambahKamar("K02", "Double", 750000);      // overload 2: data mentah
        kos.tambahKamar("K03", "Single", 500000);
        kos.tampilkanDaftarKamar();
 
        PemilikKos pemilik = new PemilikKos("PK01", "Haidar", "0812-3456-7890", kos);
        pemilik.tampilkanLaporanKos();
        System.out.println();
 
        System.out.println("=== 2. Penyewa menempati kamar (association) ===");
        Penyewa budi = new Penyewa("P01", "Budi", k01, "2026-11-01");
        Penyewa siti = new Penyewa("P02", "Siti", k01, "2026-11-01"); // K01 sudah terisi
        Kamar kosong = kos.cariKamarKosong();
        System.out.println("Kamar kosong pertama: " + kosong.getNomorKamar());
        siti = new Penyewa("P02", "Siti", kosong, "2026-11-01");
        budi.tampilkanData();
        siti.tampilkanData();
        pemilik.tampilkanLaporanKos();
        System.out.println();
 
        System.out.println("=== 3. Pembayaran (composition Penyewa-Tagihan) ===");
        System.out.println("Nominal tagihan Budi : Rp " + (long) budi.getTagihan().getNominal());
        Pembayaran bayarKurang = new Pembayaran("B01", "2026-10-25", 300000, budi);
        bayarKurang.prosesPembayaran();                 // ditolak: kurang
        Pembayaran bayarPas = new Pembayaran("B02", "2026-10-26", 500000, budi);
        bayarPas.prosesPembayaran();                    // berhasil
        bayarPas.prosesPembayaran();                    // ditolak: sudah lunas
        Pembayaran bayarRusak = new Pembayaran("B03", "2026-10-27", -5000, siti);
        bayarRusak.prosesPembayaran();                  // ditolak: jumlah tidak valid
        System.out.println();
 
        System.out.println("=== 4. Pindah kamar dan check-out ===");
        System.out.println("Budi pindah ke K03? " + budi.pindahKamar(kos.cariKamarKosong()));
        System.out.println("Siti check-out (belum bayar)? " + siti.checkOut());
        System.out.println("Budi check-out (sudah lunas)? " + budi.checkOut());
        pemilik.tampilkanLaporanKos();
        System.out.println();
 
        System.out.println("=== 5. Polymorphism: abstract class & interface ===");
        Pengguna[] daftar = { pemilik, budi, siti };
        for (Pengguna p : daftar) {
            System.out.print(p.getNama() + " (" + p.getClass().getSimpleName() + ") -> ");
            p.tampilkanPeran();
        }
        DapatDicekStatus[] status = { k01, siti.getTagihan(), budi.getTagihan() };
        for (DapatDicekStatus s : status) {
            System.out.println(s.getClass().getSimpleName() + " cekStatus() = " + s.cekStatus());
        }
    }
}