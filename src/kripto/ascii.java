/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;

/**
 *
 * @author NOVITA
 */
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ascii {

    public static void main(String[] args) {
        for (int i = 0; i < 256; i++) {
            System.out.println("ASCII code " + i + " -> " + (char) i);
        }

//    char lowercase = 'f';
//    int offset = (int) 'a' - (int) 'A';
//    char uppercase = (char) ((int) lowercase - offset);
//    System.out.println("The uppercase letter is " + uppercase);

        String numberString = "Abcd";

        for (int a = 0; a < 256; a++) {
            int code = (int) numberString.charAt(a);
            System.out.println("Karakter " + (char) code + " memiliki kode ASCII "
                    + code);
        }

    }
}
