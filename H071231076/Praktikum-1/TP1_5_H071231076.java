import java.util.Scanner;

public class TP1_5_H071231076 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        try {
            System.out.print("Masukkan Angka yang ingin dicari = ");

            if (scan.hasNextInt()) {
                int angkaCari = scan.nextInt();
                int baris = -1;
                int kolom = -1;
            
                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < nums[i].length; j++) {
                        if (nums[i][j] == angkaCari) {
                            baris = i;
                            kolom = j;
                            break;
                        }
                    }
                }

                if (baris != -1 && kolom != -1) {
                    System.out.println("Found " + angkaCari + " at [" + baris + "][" + kolom + "]");
                } else {
                    System.out.println("Angka " + angkaCari + " tidak ditemukan dalam array");
                }
            } else {
                System.out.println("Input yang dimasukkan bukan bilangan bulat");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan");
        }

        scan.close();
    }
}