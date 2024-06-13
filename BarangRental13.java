class BarangRental13 {
    String noTNKB;
    String namaKendaraan;
    String jenisKendaraan;
    int tahun;
    int biayaSewa;

    public BarangRental13(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa) {
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = biayaSewa;
    }

    @Override
    public String toString() {
        return noTNKB + " - " + namaKendaraan + " - " + jenisKendaraan + " - " + tahun + " - " + biayaSewa;
    }
}