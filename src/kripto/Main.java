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
    private static ConvertToBinary binary = new ConvertToBinary();
    
    public static void main(String[] args) {
        
        String katakunci = "TEKNIKINFORMATIK";
        String katakata  = "FAKULTAS";
        
        CreateKey getKey = new CreateKey();
        Encript encript = new Encript();
        
        String[][] keyCode = getKey.key(katakunci);
        String enc = encript.getEncript(katakata, keyCode);
        
        System.out.println("============[ hasil encript ]============");
        System.out.println(enc);
        System.out.println("===================[  ]==================");
        
        String[] arbin = binary.getBinary(enc);
        for(String s : arbin) System.out.println(s);
    }
    
}
