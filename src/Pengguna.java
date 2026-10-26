public abstract class Pengguna {
    private String id;
    private String nama;
 
    public Pengguna(String id, String nama) {
        System.out.println("Constructor Pengguna dijalankan");
        this.id = id;
        this.nama = nama;
    }
 
    public String getId() {
        return id;
    }
 
    public String getNama() {
        return nama;
    }
 
    public void tampilkanInfo() {
        System.out.println("ID   : " + id);
        System.out.println("Nama : " + nama);
    }
 
    // Abstract method: setiap jenis pengguna punya peran yang berbeda
    public abstract void tampilkanPeran();
}