package kripto;




public class CreateKey {
    
    private ConvertToBinary binary = new ConvertToBinary();
    
    public String[][] key(String str){

        String[] arrayBinary = binary.getBinary(str);
        
        String code = String.join("", arrayBinary); // hasil putaran pertama
        
        String[] keyCode = new String[48];
        int ke = 0;
        
        for (int i = 0; i < 6; i++) {
            String[] arrKey = new String[8];
            if (i == 0) {
                arrKey = code.split("(?<=\\G................)");
            }else {
                code = rotasi(code);
                arrKey = code.split("(?<=\\G................)");
            }
            
            for(String arr : arrKey) {
                keyCode[ke] = arr;
                ke++;
            }
        }
        
        String[][] newKeyCode = new String[8][6];
        
        int k = 0;
        int p = 0;
        for (int i = 0; i < keyCode.length; i++) {
            newKeyCode[p][k] = keyCode[i];
//            System.out.println( " putaran " + p + " kunci " + k + " : " + keyCode[i] + " | " + Integer.parseInt(keyCode[i], 2));
            k++;
            if (k == 6) { k = 0; p++; }
        }
        
        return newKeyCode;
    }

    private String rotasi(String code) {
        String depan = code.substring(0, 25);
        String belakang = code.substring(25, 128);
        String hasil = belakang + depan;
        return hasil;
    }
}
