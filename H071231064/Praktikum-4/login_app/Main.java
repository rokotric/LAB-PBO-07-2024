package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
     
    public static void main(String[] args) {
        
        runApp();
    }

    
    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
                break;
            default:
                // Mengulang Pemanggilan Menu Utama jika input tidak valid
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                runApp();
                break;
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");

        String username = sc.nextLine();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.nextLine();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(userIndex);
                System.exit(0);
            } else {
                System.out.println("Password Salah");
                showLoginMenu();
            }
        } else {
            System.out.println("Username tidak ditemukan.");
            showLoginMenu();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        System.out.println("Username");
        System.out.print("> ");
        String username = sc.nextLine();
        cekUsername(username);
        System.out.println("Password");
        System.out.print("> ");
        String password = sc.nextLine();
        cekPassword(password);

        User user = new User(username, password);

        Profile profile = createProfile();

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static Profile createProfile() {
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();

        return new Profile(fullName, age, hobby);
    }

    private static void showDetailUser(int profile) {
        System.out.println("-------------------------");
        System.out.println("Detail Pengguna");
        System.out.println("Nama: " + listUserProfile.get(profile).getFullName());
        System.out.println("Umur: " + listUserProfile.get(profile).getAge());
        System.out.println("Hobby: " + listUserProfile.get(profile).getHobby());
        System.out.println("Nickname: " + listUserProfile.get(profile).nickName);

        System.out.println("-------------------------");
        System.out.println("1. Update Profile");
        System.out.println("2. Return to Main Menu");
        System.out.print("> ");
    
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                updateProfile(listUser.get(profile).getUsername());
                break;
            case 2:
                runApp();
                break;
            default:
                System.out.println("Pilihan tidak valid, silakan coba lagi.");
                showDetailUser(profile);
                break;
        }
    }

    private static void cekUsername(String username){
        for(User user : listUser){
            if (user.getUsername().equals(username)) {
                System.out.println("Username telah ada!");
                showRegisterMenu();
                break;
            }
        }
    }

    private static void cekPassword(String password){
        if (password.length() <= 8) {
            System.out.println("Password harus sama dengan atau lebih dari 8 karakter");
            showRegisterMenu();
        }
    }

    private static void updateProfile(String username) {
        System.out.println("-------------------------");
        System.out.println("UPDATE PROFILE");
    
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }
    
        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();
        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Hobi");
        System.out.print("> ");
        String hobby = sc.nextLine();
    
        Profile newProfile = new Profile(fullName, age, hobby);
        listUserProfile.set(userIndex, newProfile);
    
        System.out.println("Profile updated!");
        showDetailUser(userIndex);
    }   
    
}