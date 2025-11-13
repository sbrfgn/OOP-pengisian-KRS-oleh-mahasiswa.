import java.util.Scanner;

public class KRS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=".repeat(70));
        System.out.println("         SISTEM PENGISIAN KARTU RENCANA STUDI (KRS)");
        System.out.println("=".repeat(70));

        System.out.print("\nMasukkan NIM: ");
        String nim = scanner.nextLine();
        
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama);
        
        // Input mata kuliah
        System.out.println("\n" + "=".repeat(70));
        System.out.println("PENGISIAN MATA KULIAH (Maksimal 24 SKS)");
        System.out.println("=".repeat(70));
        
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\nTotal SKS saat ini: " + mahasiswa.hitungTotalSks() + "/24");
            
            System.out.print("\nMasukkan Kode Mata Kuliah: ");
            String kode = scanner.nextLine();
            
            System.out.print("Masukkan Nama Mata Kuliah: ");
            String namaMK = scanner.nextLine();
            
            int sks = 0;
            boolean validSks = false;
            while (!validSks) {
                try {
                    System.out.print("Masukkan SKS: ");
                    sks = Integer.parseInt(scanner.nextLine());
                    if (sks > 0 && sks <= 6) {
                        validSks = true;
                    } else {
                        System.out.println("SKS harus antara 1-6!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid! Masukkan angka.");
                }
            }
            
            MatKul mk = new MatKul(kode, namaMK, sks);
            
            if (mahasiswa.tambahMataKuliah(mk)) {
                System.out.println("✓ Mata kuliah berhasil ditambahkan!");
            } else {
                System.out.println("✗ Gagal! Total SKS melebihi batas maksimal (24 SKS)");
            }
            
            if (mahasiswa.hitungTotalSks() >= 24) {
                System.out.println("\nBatas maksimal SKS tercapai!");
                lanjut = false;
            } else {
                System.out.print("\nTambah mata kuliah lagi? (y/n): ");
                String pilihan = scanner.nextLine();
                lanjut = pilihan.equalsIgnoreCase("y");
            }
        }
        
        mahasiswa.cetakKRS();
        
        scanner.close();
    }
}