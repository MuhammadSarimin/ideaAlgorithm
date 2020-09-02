package kripto;

public class CreateBinary {
    public String[] getBinary(String str){
        String[] arrBinary = new String[str.length()];
        int intStr = 0;
        for (int i = 0; i < str.length(); i++) {
            intStr = (int) str.charAt(i);
            String binary = Integer.toBinaryString(intStr);
            arrBinary[i] = ( binary.length() < 8 ) ? completeBit(binary, 8) : binary;
        }
        
        return arrBinary;
    }
    
    public String[] getText(String[] str){
        String[] hasil = new String[str.length];
        
        int i = 0;
        for(String s : str){
            int dec = Integer.parseInt(s, 2);
            char charHasil = (char)dec;
            hasil[i] = Character.toString(charHasil);
            i++;
        }
        
        return hasil;
    }
    
    private String completeBit(String str, int length){
        String hasil = str;
        String[] tambah = {"0", "00", "000", "0000", "00000", "000000", "0000000", "00000000", "000000000", "0000000000"};
        int kurang = length - str.length()-1;
        hasil = tambah[kurang] + hasil;
        
        return hasil;
    }
    
    public int[] binaryToDecimal(String[] str){
        int[] dec = new int[str.length];
        
        for (int i = 0; i < str.length; i++) {
            dec[i] = Integer.parseInt(str[i], 2);
        }
        
        return dec;
    }
    
    public String[] decimalToBinary(int[] x) {
        String[] binary = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            String str = Integer.toBinaryString(x[i]);
            binary[i] = ( str.length() < 16 ) ? completeBit(str, 16) : str;
        }
        return binary;
    }
}
