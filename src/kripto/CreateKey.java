/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

import java.util.Arrays;

public class CreateKey {
    String[] key(String str){
        String[] arrayBinary = new String[str.length()];
        int intStr = 0;
        for (int i = 0; i < str.length(); i++) {
            intStr = (int) str.charAt(i);
            String binary = Integer.toBinaryString(intStr);
            arrayBinary[i] = ( binary.length() < 8 ) ? convertTo8Bit(binary) : binary;
//            System.out.println("Karakter " + (char) intStr + " memiliki kode ASCII " + intStr);
        }
        
        String code = String.join("", arrayBinary);
//        System.out.println("asli :" + code);
        for (int i = 0; i < 5; i++) {
            code = rotasi(code);
//            System.out.println("putaran "+(i+1)+" :" + code);
        }
        
        String key = code.substring(64, 128);
        String[] arrKey = key.split("(?<=\\G................)");
//        System.out.println(java.util.Arrays.toString(arrKey));
        
        return arrKey;
    }
    
    String convertTo8Bit(String str){
        String hasil = str;
        String[] tambah = {"0", "00", "000", "0000", "00000", "000000", "0000000"};
        int kurang = 8 - str.length()-1;
        hasil = tambah[kurang] + hasil;
        
        return hasil;
    }

    private String rotasi(String code) {
        String depan = code.substring(0, 25);
        String belakang = code.substring(25, 128);
        String hasil = belakang + depan;
        return hasil;
    }
}
