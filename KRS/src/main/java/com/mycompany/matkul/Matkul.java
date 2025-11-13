class MatKul {
    private String kode;
    private String nama;
    private int sks;
    
    public MatKul(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
    
    public String getKode() {
        return kode;
    }
    
    public String getNama() {
        return nama;
    }
    
    public int getSks() {
        return sks;
    }
    
    @Override
    public String toString() {
        return String.format("%-10s %-40s %d SKS", kode, nama, sks);
    }
}
