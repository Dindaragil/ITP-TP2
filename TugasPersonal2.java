import java.io.IOException;
import java.util.Scanner;
public class TugasPersonal2 {

    static void deretAritmatika(int jumlah, int beda) {
    //ini method untuk menghitung deret aritmatika:
        int angka = 1;
        System.out.println("Deret Aritmatika: ");
        for(int i = 1; i <= jumlah; i++) {
            System.out.print(angka + " ");
            angka += beda;
        }
        System.out.printf("\n");
    };

    static void deretGeometri(int jumlah, int beda) {
    //ini method untuk menghitung deret geometri:
        int angka = 1;
        System.out.println("Deret Geometri: ");
        for(int i = 1; i <= jumlah; i++) {
            System.out.print(angka + " ");
            angka *= beda;
        }
        System.out.printf("\n");
    };

    static void faktorial(int jumlah) {
    //ini method untuk menghitung faktorial
        int angka = jumlah;
        int total = 1;
        System.out.println("Faktorial dari " + jumlah + ": ");
        for(int i = 1; i <= jumlah; i++) {
            total *= angka;
            System.out.print(angka + " ");
            if(angka != 1) {
                System.out.print("* ");
            }
            angka -= 1;
        }
        System.out.print("= " + total);
        System.out.printf("\n");
    };

    static void requestNumber() {
    //ini method untuk inputan angka
        Scanner input = new Scanner(System.in);
        int jumlah = 0, beda = 0;
        boolean jumlahSesuai = false, bedaSesuai = false;
        do {
            try {
                System.out.print("Masukkan banyak angka yang ingin dicetak [2...10]: ");
                jumlah = input.nextInt();
                input.nextLine();
                if(jumlah < 2) {
                    throw new IOException("angka < 2");
                } else if (jumlah > 10) {
                    throw new IOException("angka > 10");
                } else {
                    jumlahSesuai = true;
                }
            } catch (IOException e) {
                System.out.println("Masukan jumlah angka tidak sesuai.");
            }
        } while(!jumlahSesuai);
        do {
            try {
                System.out.print("Masukkan beda masing-masing angka yang ingin dicetak [2...9]: ");
                beda = input.nextInt();
                input.nextLine();
                if(beda < 2) {
                    throw new IOException("angka < 2");
                } else if (beda > 9) {
                    throw new IOException("angka > 9");
                } else {
                    bedaSesuai = true;
                }
            } catch (IOException e) {
                System.out.println("Beda masing-masing angka tidak sesuai.");
            }
        } while(!bedaSesuai);
        deretAritmatika(jumlah, beda);
        deretGeometri(jumlah, beda);
        faktorial(jumlah);
    };
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        boolean ulang = true;
        String keputusan = "";
        do {
            requestNumber();
            System.out.print("Apakah anda ingin mengulang program? : ");
            keputusan = input.nextLine();
            try {
                if(keputusan.equalsIgnoreCase("t")){
                    //jika user menginput t/T maka program menampilkan pesan dibawah dan berhenti
                    System.out.println("Yah, kita berhitung bersama lain kali ya!");
                    ulang = false;
                } else if(keputusan.equalsIgnoreCase("y")) {
                    //jika user menginput y/Y maka program akan diulang kembali
                    ulang = true;
                } else {
                    //jika user menginput selain t/T atau y/Y maka program akan menampilkan pesan di bawah berhenti
                    throw new IOException("Masukkan tidak sesuai ketentuan");
                }
            } catch (IOException e) {
                System.out.println("Masukkan tidak sesuai ketentuan, program terpaksa dihentikan.");
                ulang = false;
            }
        } while(ulang);
    }
}
