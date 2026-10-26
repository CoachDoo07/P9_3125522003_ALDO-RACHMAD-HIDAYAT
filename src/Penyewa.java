public class Penyewa extends Pengguna {
    private Kamar kamar;      // Association: referensi ke Kamar yang ditempati (0..1)
    private Tagihan tagihan;  // Composition: dibuat sendiri oleh Penyewa (0..1)
 
    public Penyewa(String id, String nama, Kamar kamar, String jatuhTempo) {
        super(id, nama);
        System.out.println("Constructor Penyewa dijalankan");
        if (nama == null || nama.isBlank()) {
            System.out.println("Nama penyewa tidak valid (tidak boleh kosong)");
        }
        if (kamar != null && kamar.tempati()) {
            this.kamar = kamar;
            // Composition: Tagihan dibuat di dalam Penyewa, nominal mengikuti harga kamar
            this.tagihan = new Tagihan(id + "-TGH", jatuhTempo, kamar.getHargaSewa());
        } else {
            System.out.println("Penyewa " + nama + " belum menempati kamar (kamar tidak tersedia)");
        }
    }
 
    public boolean isAktif() {
        return kamar != null;
    }
 
    public Kamar getKamar() {
        return kamar;
    }
 
    public Tagihan getTagihan() {
        return tagihan;
    }
 
    public boolean pindahKamar(Kamar kamarBaru) {
        if (!isAktif()) {
            System.out.println(getNama() + " tidak aktif, tidak bisa pindah kamar");
            return false;
        }
        if (kamarBaru == null || kamarBaru == kamar) {
            System.out.println("Kamar tujuan tidak valid");
            return false;
        }
        if (!kamarBaru.tempati()) {
            return false;
        }
        kamar.kosongkan();
        kamar = kamarBaru;
        return true;
    }
 
    // Business rule: check-out hanya boleh jika tagihan sudah lunas
    public boolean checkOut() {
        if (!isAktif()) {
            System.out.println(getNama() + " sudah tidak menempati kamar");
            return false;
        }
        if (!tagihan.cekStatus()) {
            System.out.println(getNama() + " tidak bisa check-out, tagihan belum lunas");
            return false;
        }
        kamar.kosongkan();
        kamar = null;
        return true;
    }
 
    @Override
    public void tampilkanPeran() {
        System.out.println("Penyewa - menempati kamar dan membayar tagihan sewa");
    }
 
    public void tampilkanData() {
        System.out.println("=== Data Penyewa ===");
        tampilkanInfo();
        System.out.println("Kamar : " + (kamar != null ? kamar.getNomorKamar() : "-"));
        System.out.println("--------------------");
    }
}