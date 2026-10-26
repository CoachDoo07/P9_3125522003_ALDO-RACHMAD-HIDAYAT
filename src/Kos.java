import java.util.ArrayList;
import java.util.List;
 
public class Kos {
    private String namaKos;
    private List<Kamar> daftarKamar; // Aggregation: kamar dibuat di luar class Kos
 
    public Kos(String namaKos) {
        this.namaKos = namaKos;
        this.daftarKamar = new ArrayList<>();
    }
 
    public String getNamaKos() {
        return namaKos;
    }
 
    // Overloading 1: menambahkan Kamar yang sudah dibuat
    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }
 
    // Overloading 2: membuat Kamar baru dari data mentah
    public void tambahKamar(String nomorKamar, String tipeKamar, double hargaSewa) {
        daftarKamar.add(new Kamar(nomorKamar, tipeKamar, hargaSewa));
    }
 
    public Kamar cariKamarKosong() {
        for (Kamar k : daftarKamar) {
            if (k.isStatusTersedia()) {
                return k;
            }
        }
        return null;
    }
 
    public int jumlahKamarTersedia() {
        int jumlah = 0;
        for (Kamar k : daftarKamar) {
            if (k.isStatusTersedia()) {
                jumlah++;
            }
        }
        return jumlah;
    }
 
    // Potensi pendapatan bulanan = total harga sewa kamar yang sedang terisi
    public double hitungPotensiPendapatan() {
        double total = 0;
        for (Kamar k : daftarKamar) {
            if (!k.isStatusTersedia()) {
                total += k.getHargaSewa();
            }
        }
        return total;
    }
 
    public void tampilkanDaftarKamar() {
        System.out.println("=== Daftar Kamar di " + namaKos + " ===");
        for (Kamar k : daftarKamar) {
            k.tampilkanData();
        }
    }
}