
import java.util.Scanner;


public class grammerEbnf {
    
    
    public static boolean grammerKontrol(String[] ozneDizisi, String[] nesneDizisi, String[] yuklemDizisi, String cumle) {
        // split yardımı ile cümlenin ögelerini boşluklardan ayırıp diziye dönüştürüyoruz.
        String[] kelimeler = cumle.split("\\s+");
        
        // Cümlenin uzunluğunu kontrol ediyoruz (3 kelime olmalı).
        if (kelimeler.length != 3) {
            return false;
        }
        
        String ozne = kelimeler[0];
        String nesne = kelimeler[1];
        String yuklem = kelimeler[2];
        
        if (!kontrol(ozneDizisi, ozne) || !kontrol(nesneDizisi, nesne) || !kontrol(yuklemDizisi, yuklem)) {
            return false;
        }

        return true;
    }
    
    
    public static boolean kontrol(String[] dizi, String kelime) {
        //kelimenin uygun dizi içerisinde olup olmadığını kontrol ederiz.
        for (int i=0; i < dizi.length; i++){
            if (dizi[i].equalsIgnoreCase(kelime)) {  //IgnoreCase yardımı ile büyük küçük harf kuralını ortadan kaldırırız.
                return true;
            }
        }
        return false;
    }
    
    
    
    
    public static void main(String[] args) {
        // Özne, nesne ve yüklem dizilerini oluşturuyoruz
        String[] ozneDizisi = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneDizisi = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemDizisi = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};
        
       
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lutfen bir cumle girin:");
        String cumle = scanner.nextLine();    
    
        if (grammerKontrol(ozneDizisi, nesneDizisi, yuklemDizisi, cumle)) {
            System.out.println("EVET.");
        }
        
        else {
            System.out.println("HAYIR");
        }    
    
    }

}
