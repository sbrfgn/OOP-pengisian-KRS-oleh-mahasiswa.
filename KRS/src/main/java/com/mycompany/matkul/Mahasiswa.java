import java.util.ArrayList;

class Mahasiswa {
    private String nim;
    private String nama;
    private ArrayList<MatKul> daftarMK;
    private static final int MAX_SKS = 24;
    
    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.daftarMK = new ArrayList<>();
    }
    
    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public boolean tambahMataKuliah(MatKul mk) {
        int totalSks = hitungTotalSks();
        if (totalSks + mk.getSks() <= MAX_SKS) {
            daftarMK.add(mk);
            return true;
        }
        return false;
    }
    
    public int hitungTotalSks() {
        int total = 0;
        for (MatKul mk : daftarMK) {
            total += mk.getSks();
        }
        return total;
    }
    
    public ArrayList<MatKul> getDaftarMK() {
        return daftarMK;
    }
    
    public void cetakKRS() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("           KARTU RENCANA STUDI (KRS)");
        System.out.println("=".repeat(70));
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("=".repeat(70));
        System.out.println("Daftar Mata Kuliah:");
        System.out.println("-".repeat(70));
        System.out.printf("%-5s %-10s %-40s %-10s\n", "No", "Kode", "Nama Mata Kuliah", "SKS");
        System.out.println("-".repeat(70));
        
        int no = 1;
        for (MatKul mk : daftarMK) {
            System.out.printf("%-5d %-10s %-40s %-10d\n", 
                no++, mk.getKode(), mk.getNama(), mk.getSks());
        }
        
        System.out.println("-".repeat(70));
        System.out.println("Total SKS: " + hitungTotalSks());
        System.out.println("=".repeat(70));
        System.out.println("\nMengetahui,");
        System.out.println("Ketua Program Studi\n\n\n");
        System.out.println("_______________________");
        System.out.println("NIP. 1234567890");
        System.out.println("=".repeat(70));
    }
}
