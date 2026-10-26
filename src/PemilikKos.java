public class PemilikKos extends Pengguna {
    private String nomorTelepon;
    private Kos kos; // Association: pemilik mengelola satu Kos
 
    public PemilikKos(String id, String nama, String nomorTelepon, Kos kos) {
        super(id, nama);
        System.out.println("Constructor PemilikKos dijalankan");
        ubahNomorTelepon(nomorTelepon);
        this.kos = kos;
    }
 
    public String getNomorTelepon() {
        return nomorTelepon;
    }
 
    public Kos getKos() {
        return kos;
    }
 
    public void ubahNomorTelepon(String nomorBaru) {
        if (nomorBaru != null && !nomorBaru.isBlank()) {
            this.nomorTelepon = nomorBaru;
        } else {
            System.out.println("Nomor telepon tidak valid (tidak boleh kosong)");
        }
    }
 
    // Responsibility: pemilik memantau kondisi kos yang dikelolanya
    public void tampilkanLaporanKos() {
        System.out.println("=== Laporan " + kos.getNamaKos() + " ===");
        System.out.println("Kamar tersedia      : " + kos.jumlahKamarTersedia());
        System.out.println("Potensi pendapatan  : Rp " + (long) kos.hitungPotensiPendapatan() + " / bulan");
        System.out.println("-------------------------");
    }
 
    @Override
    public void tampilkanPeran() {
        System.out.println("Pemilik Kos - mengelola data kamar dan memantau penyewa");
    }
}
 