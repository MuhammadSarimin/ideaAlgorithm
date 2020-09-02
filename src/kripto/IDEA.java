package kripto;

public class IDEA {
    
    private CreateBinary binary = new CreateBinary();
    
    public String Execute(String str, String[] key){
        String[] stringBinary = binary.getBinary(str);
        String[] x = new String[4];
        int idx = 0;
        
        for(int i = 0; i < 4; i++) x[i] = stringBinary[idx++] + stringBinary[idx++];
        
        int n = 0;
        for(int p = 0; p < 8; p++){ // x biasa
            int i = 0;
            String[] temp = new String[6]; // temp kunci sementara
            for(int k = 0; k < 6; k++) temp[i++] = key[n++];
            x = getXBaru(x, temp);
            System.out.println("===================");
        }
        System.out.println("===================");
        String[] temp = new String[4]; // x tranformasi output
        for(int i = 0; i < 4; i++) temp[i] = key[n++];
        x = getTransformasiOutput(x, temp);
        for ( String s : x ) System.out.println(s + " | " + Integer.parseInt(s, 2));
        String[] binaryHasil = new String[8];
        
        int i = 0;
        for(String sOut : x) {
            String[] arrKey = sOut.split("(?<=\\G........)");
            binaryHasil[i++]   = arrKey[0];
            binaryHasil[i++] = arrKey[1];
        }
        
        for( String s : binaryHasil) System.out.println(s + " | " + Integer.parseInt(s,2));
        
        String[] hasil = binary.getText(binaryHasil);
        return String.join("", hasil);
    }
    
    private String[] getXBaru(String[] xStr, String[] key) {
        
        int[] x  = binary.binaryToDecimal(xStr);
        int[] k     = binary.binaryToDecimal(key);
        
        long l1 = ((long)x[0] * (long)k[0]) % ((long)65537);    System.out.println("L1  = " + l1 + " || " + x[0] + " x " + k[0] + " mod(65537)");
        long l2 = (x[1] + k[1]) % 65536;                        System.out.println("L2  = " + l2 + " || " + x[1] + " + " + k[1] + " mod(65536)");
        long l3 = (x[2] + k[2]) % 65536;                        System.out.println("L3  = " + l3 + " || " + x[2] + " + " + k[2] + " mod(65536)");
        long l4 = ((long)x[3] * (long)k[3]) % ((long)65537);    System.out.println("L4  = " + l4 + " || " + x[3] + " x " + k[3] + " mod(65537)");
        long l5 = l1 ^ l3 ;                                     System.out.println("L5  = " + l5 + " || " + l1 + " XOR " + l3);
        long l6 = l2 ^ l4 ;                                     System.out.println("L6  = " + l6 + " || " + l2 + " XOR " + l4);
        long l7 = ((long)l5 * (long)k[4]) % ((long)65537);      System.out.println("L7  = " + l7 + " || " + l5 + " x " + k[4] + " mod(65537)");
        long l8 = (l6 + l7) % 65536;                            System.out.println("L8  = " + l8 + " || " + l6 + " + " + l7 + " mod(65536)");
        long l9 = ((long)l8 * (long)k[5]) % ((long)65537);      System.out.println("L9  = " + l9 + " || " + l8 + " x " + k[5] + " mod(65537)");
        long l10 = (l7 + l9) % 65536;                           System.out.println("L10 = " + l10 + " || " + l7 + " + " + l9 + " mod(65536)");
        
        int[] xTemp = new int[4];
        
        xTemp[0] = (int)(l1 ^ l9);  System.out.println("L11 = " + xTemp[0] + " || " + l1 + " XOR " + l9);
        xTemp[1] = (int)(l3 ^ l9);  System.out.println("L12 = " + xTemp[1] + " || " + l3 + " XOR " + l9);
        xTemp[2] = (int)(l2 ^ l10); System.out.println("L13 = " + xTemp[2] + " || " + l2 + " XOR " + l10);
        xTemp[3] = (int)(l4 ^ l10); System.out.println("L14 = " + xTemp[3] + " || " + l4 + " XOR " + l10);
        String[] xBaru = binary.decimalToBinary(xTemp);
                
        return xBaru;
    }
    
    private String[] getTransformasiOutput(String[] xStr, String[] key) {
        int[] x  = binary.binaryToDecimal(xStr);
        int[] k     = binary.binaryToDecimal(key);
        
        int[] xTemp = new int[4];
        
        xTemp[0] = (int)( ((long)x[0] * (long)k[0]) % ((long)65537) );  System.out.println("Y1 = " + xTemp[0] + " || " + x[0] + " x " + k[0] + " mod(65537)");
        xTemp[1] = (x[1] + k[1]) % 65536;                               System.out.println("Y2 = " + xTemp[1] + " || " + x[1] + " + " + k[1] + " mod(65536)");
        xTemp[2] = (x[2] + k[2]) % 65536;                               System.out.println("Y3 = " + xTemp[2] + " || " + x[2] + " + " + k[2] + " mod(65536)");
        xTemp[3] = (int)( ((long)x[3] * (long)k[3]) % ((long)65537) );  System.out.println("Y4 = " + xTemp[3] + " || " + x[3] + " x " + k[3] + " mod(65537)\n");
        
        String[] xBaru = binary.decimalToBinary(xTemp);
                
        return xBaru;
    }
}
