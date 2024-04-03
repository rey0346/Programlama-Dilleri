/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bagli_sirala;
 import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Bagli_Sirala {

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
       Scanner sc = new Scanner(System.in);
        System.out.print("DOSYA ADİNİ GİRİNİZ: ");
        String dosyaAdi = sc.nextLine();
        int ss = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            while (reader.readLine() != null)
                ss++;
        }

        int[] dizi = new int[ss];

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            int index = 0;
            String dosyaSatir;
         while ((dosyaSatir = reader.readLine()) != null)
         dizi[index++] = Integer.parseInt(dosyaSatir);
        }
        
        int n = dizi.length;
        bagliListe[] bl1 = new bagliListe[n];
        bagliListe[] bl2 = new bagliListe[n];

        for (int i = 0; i < n; i++){
            bl1[i] = new bagliListe(dizi[i], i);
            bl2[i] = new bagliListe(dizi[i], i);
        }

        bagliListe[] temp = new bagliListe[n];

        for (int i = 0; i < n; i++) 
            temp[i] = bl1[i];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (temp[j].veri > temp[j + 1].veri) {
                    bagliListe t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }
            }
        }

        int adres = temp[0].adres;
        
        for (int i = 0; i < n - 1; i++) 
            temp[i].adres = temp[i + 1].adres;

        temp[n - 1].adres = adres;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[j].veri == bl1[i].veri) 
                    bl1[i].adres = temp[j].adres;
            }
        }
        
     
        for(int i = 0; i < n; i++){
            System.out.println(bl2[i].veri + " ---- " + bl2[i].adres + "        " + bl1[i].veri + " ---- " + bl1[i].adres);
        }

        
        
        
    }
    
}
