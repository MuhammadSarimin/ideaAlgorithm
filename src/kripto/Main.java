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
        
        String katakunci = "TEKNIKINFORMATIK";
        String katakata  = "FAKULTAS";
        
        CreateKey createKey = new CreateKey();
                  IDEA Idea = new IDEA();
//        
        String[] eKey = createKey.encript(katakunci);
        String[] dKey = createKey.decript(katakunci);
        
        String encript = Idea.Execute(katakata, eKey);
        System.out.println(encript);
        System.out.println("\n\n\n\n");
        String decript = Idea.Execute(encript, dKey);
        System.out.println(decript);
    }
    
}
