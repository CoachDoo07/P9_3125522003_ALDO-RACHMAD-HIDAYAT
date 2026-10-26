public class Pembayaran {
    private String idPembayaran;
    private String tanggalBayar;
    private double jumlahBayar;
    private Penyewa penyewa; // Association: pembayaran dilakukan oleh penyewa
 
    public Pembayaran(String idPembayaran, String tanggalBayar, double jumlahBayar, Penyewa penyewa) {
        this.idPembayaran = idPembayaran;
        this.tanggalBayar = tanggalBayar;
        this.penyewa = penyewa;
        if (jumlahBayar > 0) {
            this.jumlahBayar = jumlahBayar;
        } else {
            System.out.println("Jumlah bayar tidak valid (harus lebih dari 0)");
        }
    }
 
    public String getIdPembayaran() {
        return idPembayaran;
    }
 
    public String getTanggalBayar() {
        return tanggalBayar;
    }
 
    public double getJumlahBayar() {
        return jumlahBayar;
    }
 
    public Penyewa getPenyewa() {
        return penyewa;
    }
 
    // Responsibility: memproses pembayaran ke tagihan milik penyewa
    public boolean prosesPembayaran() {
        if (jumlahBayar <= 0) {
            System.out.println("Pembayaran " + idPembayaran + " tidak bisa diproses (jumlah tidak valid)");
            return false;
        }
        if (!penyewa.isAktif()) {
            System.out.println("Pembayaran " + idPembayaran + " ditolak, penyewa tidak aktif");
            return false;
        }
        boolean berhasil = penyewa.getTagihan().bayar(jumlahBayar);
        if (berhasil) {
            System.out.println("Pembayaran " + idPembayaran + " berhasil: tagihan "
                    + penyewa.getTagihan().getIdTagihan() + " milik " + penyewa.getNama() + " lunas");
        }
        return berhasil;
    }
 
    public void tampilkanData() {
        System.out.println("=== Data Pembayaran ===");
        System.out.println("ID Pembayaran  : " + idPembayaran);
        System.out.println("Penyewa        : " + penyewa.getNama());
        System.out.println("Tanggal Bayar  : " + tanggalBayar);
        System.out.println("Jumlah Bayar   : Rp " + (long) jumlahBayar);
        System.out.println("-----------------------");
    }
}