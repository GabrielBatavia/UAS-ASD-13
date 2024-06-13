import java.util.Scanner;

public class Main {
    private static LinkedList13<BarangRental13> daftarBarang13 = new LinkedList13<>();
    private static LinkedList13<TransaksiRental13> daftarTransaksi13 = new LinkedList13<>();
    private static Scanner sc13 = new Scanner(System.in);
    private static int transaksiCounter = 1;

    public static void main(String[] args) {
        inisialisasiData();
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = sc13.nextInt();
            sc13.nextLine(); 
            switch (choice) {
                case 1:
                    displayDaftarBarang();
                    break;
                case 2:
                    peminjaman();
                    break;
                case 3:
                    displayDaftarTransaksi();
                    break;
                case 4:
                    urutkanTransaksi();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }

    private static void inisialisasiData() {
        daftarBarang13.addLast(new BarangRental13("B 4567 XY", "Honda Beat", "Motor", 2017, 25000));
        daftarBarang13.addLast(new BarangRental13("N 4511 VS", "Honda Vario", "Motor", 2018, 25000));
        daftarBarang13.addLast(new BarangRental13("IN 4531 AA", "Toyota Yaris", "Mobil", 2019, 40000));
        daftarBarang13.addLast(new BarangRental13("AB 4321 AQ", "Toyota Innova", "Mobil", 2019, 40000));
        daftarBarang13.addLast(new BarangRental13("B 1234 AG", "Toyota Avanza", "Mobil", 2021, 40000));
    }




    private static void displayMenu() {
        System.out.println("Menu");
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Peminjaman");
        System.out.println("3. Tampilkan seluruh transaksi");
        System.out.println("4. Urutkan Transaksi urut no TNKB");
        System.out.println("5. Keluar");
        
        System.out.print("Pilih (1-5): ");
    }

    private static void displayDaftarBarang() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Kendaraan Rental Serba Serbi");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < daftarBarang13.size(); i++) {
            System.out.println(daftarBarang13.get(i));
        }
    }

    private static void peminjaman() {
        System.out.print("Masukkan Nama Peminjam: ");
        String namaPeminjam = sc13.nextLine();
        System.out.print("Masukkan Nomor TNKB: ");
        String noTNKB = sc13.nextLine();
        System.out.print("Masukkan Lama Pinjam (hari): ");
        int lamaPinjam = sc13.nextInt();
        sc13.nextLine();
        System.out.print("Apakah Member (y/t): ");
        boolean isMember = sc13.nextLine().equalsIgnoreCase("y");

        BarangRental13 barang = null;
        for (int i = 0; i < daftarBarang13.size(); i++) {
            if (daftarBarang13.get(i).noTNKB.equals(noTNKB)) {
                barang = daftarBarang13.get(i);
                break;
            }
        }
        if (barang == null) {
            System.out.println("Barang tidak ditemukan");
            return;
        }

        double totalBiaya = lamaPinjam * barang.biayaSewa;
        if (isMember) {
            totalBiaya -= 25000; 
        }

        if (lamaPinjam >= 48 && lamaPinjam <= 78) {
            totalBiaya *= 0.9;
        } else if (lamaPinjam > 78) {
            totalBiaya *= 0.8;
        }

        TransaksiRental13 transaksi = new TransaksiRental13(transaksiCounter++, namaPeminjam, lamaPinjam, totalBiaya, barang);
        daftarTransaksi13.addLast(transaksi);
        System.out.println("Transaksi berhasil ditambahkan");
    }

    private static void displayDaftarTransaksi() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Transaksi Peminjaman Rental Serba Serbi");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < daftarTransaksi13.size(); i++) {
            System.out.println(daftarTransaksi13.get(i));
        }
    }

    private static void urutkanTransaksi() {
        daftarTransaksi13.sort((tr1, tr2) -> {
            char firstChar1 = tr1.namaPeminjam.charAt(0);
            char firstChar2 = tr2.namaPeminjam.charAt(0);
            if (firstChar1 >= 'A' && firstChar1 <= 'M') {
                if (firstChar2 >= 'A' && firstChar2 <= 'M') {
                    return tr2.br.noTNKB.compareTo(tr1.br.noTNKB);
                } else {
                    return -1;
                }
            } else {
                if (firstChar2 >= 'A' && firstChar2 <= 'M') {
                    return 1;
                } else {
                    return tr2.namaPeminjam.compareTo(tr1.namaPeminjam);
                }
            }
        });
        System.out.println("Transaksi berhasil diurutkan");
    }

}
