package kripto;



public class Encript {
    
    private ConvertToBinary binary = new ConvertToBinary();
    
    public String getEncript(String str, String[][] key){
        
        String[] arrayBinary = binary.getBinary(str);
        String[] x = new String[4];
        
        int idx = 0;
        
        for (int i = 0; i < arrayBinary.length; i+=2) {
            x[idx] = arrayBinary[i] + arrayBinary[i+1];
            idx++;
        }        
        
        for(String[] k : key)
            x = getXBaru(x, k);
        
        String[] output = getTransformasiOutput(x, key[7]);
        String[] binaryHasil = new String[8];
        
        int i = 0;
        for(String sOut : output) {
            String[] arrKey = sOut.split("(?<=\\G........)");
            binaryHasil[i]   = arrKey[0];
            binaryHasil[i+1] = arrKey[1];
            i+=2;
        }
        
        String[] hasil = binary.getText(binaryHasil);
        return String.join("", hasil);
    }

    private String[] getXBaru(String[] xStr, String[] key) {
        
        int[] x  = binary.binaryToDecimal(xStr);
        int[] k     = binary.binaryToDecimal(key);
        
        long l1 = ((long)x[0] * (long)k[0]) % ((long)65537);
        long l2 = (x[1] + k[1]) % 65536;
        long l3 = (x[2] + k[2]) % 65536;
        long l4 = ((long)x[3] * (long)k[3]) % ((long)65537);
        long l5 = l1 ^ l3 ;
        long l6 = l2 ^ l4 ;
        long l7 = ((long)l5 * (long)k[4]) % ((long)65537);
        long l8 = (l6 + l7) % 65536;
        long l9 = ((long)l8 * (long)k[5]) % ((long)65537);
        long l10 = (l7 + l9) % 65536;
        
        int[] xTemp = new int[4];
        
        xTemp[0] = (int)(l1 ^ l9);
        xTemp[1] = (int)(l3 ^ l9);
        xTemp[2] = (int)(l2 ^ l10);
        xTemp[3] = (int)(l4 ^ l10);
        
        String[] xBaru = binary.decimalToBinary(xTemp);
                
        return xBaru;
    }

    private String[] getTransformasiOutput(String[] xStr, String[] key) {
        int[] x  = binary.binaryToDecimal(xStr);
        int[] k     = binary.binaryToDecimal(key);
        
        int[] xTemp = new int[4];
        
        xTemp[0] = (int)( ((long)x[0] * (long)k[2]) % ((long)65537) );
        xTemp[1] = (x[1] + k[3]) % 65536;
        xTemp[2] = (x[2] + k[4]) % 65536;
        xTemp[3] = (int)( ((long)x[3] * (long)k[5]) % ((long)65537) );
        
        String[] xBaru = binary.decimalToBinary(xTemp);
                
        return xBaru;
    }
}
