package kripto;



public class ConvertToBinary {
    
    public String[] getBinary(String str){
        String[] arrBinary = new String[str.length()];
        int intStr = 0;
        for (int i = 0; i < str.length(); i++) {
            intStr = (int) str.charAt(i);
            String binary = Integer.toBinaryString(intStr);
            arrBinary[i] = ( binary.length() < 8 ) ? convertTo8Bit(binary) : binary;
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
            binary[i] = ( str.length() < 16 ) ? convertTo16Bit(str) : str;
        }
        return binary;
    }
    
    private String convertTo8Bit(String str){
        String hasil = str;
        String[] tambah = {"0", "00", "000", "0000", "00000", "000000", "0000000"};
        int kurang = 8 - str.length()-1;
        hasil = tambah[kurang] + hasil;
        
        return hasil;
    }

    private String convertTo16Bit(String str){
        String hasil = str;
        String[] tambah = {"0", "00", "000", "0000", "00000", "000000", "0000000"};
        int kurang = 16 - str.length()-1;
        hasil = tambah[kurang] + hasil;
        
        return hasil;
    }
}
