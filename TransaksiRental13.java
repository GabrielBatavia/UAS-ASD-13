class TransaksiRental13 {
    int kodeTransaksi;
    String namaPeminjam;
    int lamaPinjam;
    double totalBiaya;
    BarangRental13 br;

    public TransaksiRental13(int kodeTransaksi, String namaPeminjam, int lamaPinjam, double totalBiaya, BarangRental13 br) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.totalBiaya = totalBiaya;
        this.br = br;
    }

    @Override
    public String toString() {
        return "Transaksi " + kodeTransaksi + ": " + namaPeminjam + " - " + lamaPinjam + " hari - " + totalBiaya + " - " + br.toString();
    }
}