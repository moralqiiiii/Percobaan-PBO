import java.util.HashMap; //ni memberikan kinerja konstan untuk operasi dasar seperti get dan put
import java.util.Map; // Ini menyediakan metode untuk operasi dasar seperti menambah, menghapus, dan mengambil elemen berdasarkan kunci mereka
import java.util.Scanner; //ni umumnya digunakan untuk membaca input pengguna

class User {
    String username;
    String password;
    String nama;
    String nim;
    int umur;
    String kelas;

    public User(String username, String password, String nama, String nim, int umur, String kelas) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nim = nim;
        this.umur = umur;
        this.kelas = kelas;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public int getUmur() {
        return umur;
    }

    public String getKelas() {
        return kelas;
    }
}

class LibrarySystem {
    Map<String, User> users;
    Scanner scanner;

    public LibrarySystem() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);

        // Inisialisasi admin dan mahasiswa
        addUser(new User("Johny Dalton", "Dalton88221", "Johny Dalton", "-", 20, "F"));
        addUser(new User("202310370311296", "password1", "Mochammad Rifqi Al Baihaqi", "202310370311296", 19, "Kelas F"));
        addUser(new User("202310370311899", "password2", "Agustus Subianto", "202310370311899", 19, "Kelas F"));
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void adminLogin(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Admin login berhasil");
            displayUserInfo(user);
        } else {
            System.out.println("Admin login gagal. Username atau password salah.");
        }
    }

    public void mahasiswaLogin(String nim) {
        User user = users.get(nim);
        if (user != null && user.getNim().length() == 15) {
            System.out.println("Mahasiswa login berhasil");
            displayUserInfo(user);
        } else {
            System.out.println("Mahasiswa login gagal. NIM tidak terdaftar.");
        }
    }

    public void displayUserInfo(User user) {
        System.out.println("Nama: " + user.getNama());
        System.out.println("NIM: " + user.getNim());
        System.out.println("Umur: " + user.getUmur());
        System.out.println("Kelas: " + user.getKelas());
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        Scanner scanner = new Scanner(System.in);

        // Input pilihan pengguna
        System.out.println("Pilih jenis pengguna (admin (1) / mahasiswa (2) ):");
        String userType = scanner.nextLine();

        if (userType.equals("1")) {
            // Input username dan password admin
            System.out.println("Masukkan username anda:");
            String username = scanner.nextLine();
            System.out.println("Masukkan password anda:");
            String password = scanner.nextLine();
            library.adminLogin(username, password);
        } else if (userType.equals("2")) {
            // Input NIM mahasiswa
            System.out.println("Masukkan NIM anda:");
            String nim = scanner.nextLine();
            library.mahasiswaLogin(nim);
        } else {
            System.out.println("Jenis pengguna tidak valid.");
        }

        scanner.close();
    }
}