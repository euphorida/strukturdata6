import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.*;

public class DataPraktikan {
    private HashMap<String, String> tabelData;
    private HashMap<String, String> tabelSesiLogin;
    private boolean loggedIn;
    private Scanner scanner;

    public DataPraktikan() {
        tabelData = new HashMap<>();
        tabelSesiLogin = new HashMap<>();
        loggedIn = false;
        scanner = new Scanner(System.in);
    }

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (!tabelData.containsKey(nimPraktikan) && nimPraktikan.startsWith("IF")) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        }
        return false;
    }

    public void tampil() {
        System.out.println("Data Praktikan:");
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + ", Nama Asisten: " + entry.getValue());
        }
    }

    public void listNimPraktikan() {
        System.out.println("Daftar NIM Praktikan:");
        for (String nimPraktikan : tabelData.keySet()) {
            System.out.println(nimPraktikan);
        }
    }

    public void listNamaAsisten() {
        System.out.println("Daftar Nama Asisten:");
        for (String namaAsisten : new HashSet<>(tabelData.values())) {
            System.out.println(namaAsisten);
        }
    }

    public int totalData() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            return true;
        }
        return false;
    }

    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data berhasil diubah.");
        } else {
            System.out.println("NIM Praktikan tidak ditemukan.");
        }
    }

    public void search(String namaAsisten) {
        System.out.println("NIM Praktikan dengan Nama Asisten " + namaAsisten + ":");
        boolean found = false;
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println(entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ada NIM Praktikan dengan Nama Asisten " + namaAsisten);
        }
    }

    public void login() {
        System.out.println("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.println("Masukkan password: ");
        String password = scanner.nextLine();

        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password) && email.endsWith("@umm.ac.id")) {
            loggedIn = true;
            System.out.println("Login berhasil.");
            System.out.println("Fitur yang tersedia:");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil");
            System.out.println("3. List NIM Praktikan");
            System.out.println("4. List Nama Asisten");
            System.out.println("5. Total Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. Edit Data");
            System.out.println("8. Search");
            System.out.println("9. Logout");

            while (loggedIn) {
                System.out.println("\nPilih fitur (1-9): ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline character

                switch (pilihan) {
                    case 1:
                        System.out.println("Masukkan NIM Praktikan: ");
                        String nimPraktikan = scanner.nextLine();
                        System.out.println("Masukkan Nama Asisten: ");
                        String namaAsisten = scanner.nextLine();
                        tambahData(nimPraktikan, namaAsisten);
                        break;
                    case 2:
                        tampil();
                        break;
                    case 3:
                        listNimPraktikan();
                        break;
                    case 4:
                        listNamaAsisten();
                        break;
                    case 5:
                        System.out.println("Total Data: " + totalData());
                        break;
                    case 6:
                        System.out.println("Masukkan NIM Praktikan yang akan dihapus: ");
                        nimPraktikan = scanner.nextLine();
                        System.out.println("Masukkan Nama Asisten yang akan dihapus: ");
                        namaAsisten = scanner.nextLine();
                        hapusData(nimPraktikan, namaAsisten);
                        break;
                    case 7:
                        System.out.println("Masukkan NIM Praktikan yang akan diubah: ");
                        nimPraktikan = scanner.nextLine();
                        System.out.println("Masukkan Nama Asisten yang baru: ");
                        namaAsisten = scanner.nextLine();
                        editData(nimPraktikan, namaAsisten);
                        break;
                    case 8:
                        System.out.println("Masukkan Nama Asisten untuk melakukan pencarian: ");
                        namaAsisten = scanner.nextLine();
                        search(namaAsisten);
                        break;
                    case 9:
                        logout();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            }
        } else {
            System.out.println("Gagal Login");
        }
    }

    public void logout() {
        loggedIn = false;
        System.out.println("Anda telah keluar dari program.");
    }

    public static void main(String[] args) {
        DataPraktikan data = new DataPraktikan();

        data.tambahData("IF123456", "Asisten1");
        data.tambahData("IF789012", "Asisten2");
        data.tambahData("IF345678", "Asisten3");

        data.tabelSesiLogin.put("farida@umm.ac.id", "123456"); // Contoh data login

        data.login();
    }
}