public class Tagihan implements DapatDicekStatus {
    private String idTagihan;
    private String jatuhTempo;
    private double nominal;
    private boolean statusLunas;
 
    public Tagihan(String idTagihan, String jatuhTempo, double nominal) {
        this.idTagihan = idTagihan;
        this.jatuhTempo = jatuhTempo;
        this.nominal = nominal;
        this.statusLunas = false;
    }
 
    public String getIdTagihan() {
        return idTagihan;
    }
 
    public String getJatuhTempo() {
        return jatuhTempo;
    }
 
    public double getNominal() {
        return nominal;
    }
 
    // Responsibility: tagihan sendiri yang memutuskan apakah pembayaran cukup
    public boolean bayar(double jumlah) {
        if (statusLunas) {
            System.out.println("Tagihan " + idTagihan + " sudah lunas");
            return false;
        }
        if (jumlah < nominal) {
            System.out.println("Pembayaran kurang: tagihan Rp " + (long) nominal
                    + ", dibayar Rp " + (long) jumlah);
            return false;
        }
        statusLunas = true;
        return true;
    }
 
    @Override
    public boolean cekStatus() {
        return statusLunas;
    }
 
    public void tampilkanData() {
        System.out.println("=== Data Tagihan ===");
        System.out.println("ID Tagihan  : " + idTagihan);
        System.out.println("Jatuh Tempo : " + jatuhTempo);
        System.out.println("Nominal     : Rp " + (long) nominal);
        System.out.println("Status      : " + (statusLunas ? "Lunas" : "Belum Lunas"));
        System.out.println("--------------------");
    }
}