public class Kamar implements DapatDicekStatus {
    private String nomorKamar;
    private String tipeKamar;
    private double hargaSewa;
    private boolean statusTersedia;
 
    public Kamar(String nomorKamar, String tipeKamar, double hargaSewa) {
        this.nomorKamar = nomorKamar;
        ubahTipe(tipeKamar);
        ubahHargaSewa(hargaSewa);
        this.statusTersedia = true; // kamar baru selalu tersedia
    }
 
    public String getNomorKamar() {
        return nomorKamar;
    }
 
    public String getTipeKamar() {
        return tipeKamar;
    }
 
    public double getHargaSewa() {
        return hargaSewa;
    }
 
    public boolean isStatusTersedia() {
        return statusTersedia;
    }
 
    // Validasi: tipe hanya Single atau Double
    public void ubahTipe(String tipeBaru) {
        if (tipeBaru != null
                && (tipeBaru.equalsIgnoreCase("Single") || tipeBaru.equalsIgnoreCase("Double"))) {
            this.tipeKamar = tipeBaru;
        } else {
            System.out.println("Tipe kamar tidak valid (harus Single atau Double)");
        }
    }
 
    // Validasi: harga sewa harus lebih dari 0
    public void ubahHargaSewa(double hargaBaru) {
        if (hargaBaru > 0) {
            this.hargaSewa = hargaBaru;
        } else {
            System.out.println("Harga sewa tidak valid (harus lebih dari 0)");
        }
    }
 
    // Responsibility: kamar sendiri yang menjaga statusnya
    public boolean tempati() {
        if (!statusTersedia) {
            System.out.println("Kamar " + nomorKamar + " sudah terisi");
            return false;
        }
        statusTersedia = false;
        return true;
    }
 
    public void kosongkan() {
        statusTersedia = true;
    }
 
    @Override
    public boolean cekStatus() {
        return statusTersedia;
    }
 
    public void tampilkanData() {
        System.out.println("=== Data Kamar ===");
        System.out.println("Nomor Kamar : " + nomorKamar);
        System.out.println("Tipe Kamar  : " + tipeKamar);
        System.out.println("Harga Sewa  : Rp " + (long) hargaSewa);
        System.out.println("Status      : " + (statusTersedia ? "Tersedia" : "Terisi"));
        System.out.println("------------------");
    }
}