/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kripto;
public class Main {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateKey key = new CreateKey();
        String[] keyCode = key.key("TEKNIKINFORMATIK");
        for (int i = 0; i < keyCode.length; i++) {
            System.out.println( "key " + (i+1) + " : " + keyCode[i] + " | " + Integer.parseInt(keyCode[i], 2));
        }
    }
    
}
