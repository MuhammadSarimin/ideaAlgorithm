package kripto;

public class CreateKey {
    
    private CreateBinary binary = new CreateBinary();
    
    public String[] encript (String str){
        String[] arrayBinary = binary.getBinary(str);
        String code = String.join("", arrayBinary); // hasil putaran pertama
        
        String[] keyCode = new String[52];
        int ke = 0;
        for (int i = 0; i < 6; i++) {
            String[] arrKey = new String[8];
            if (i == 0)
                arrKey = code.split("(?<=\\G................)");
            else {
                code = rotasi(code);
                arrKey = code.split("(?<=\\G................)");
            }
            
            for(String arr : arrKey) keyCode[ke++] = arr;
        }
        
        for(int i = 48; i < 52; i++) keyCode[i] = keyCode[i-4];
        
        
        return keyCode;
    }
    
    public String[] decript (String str){
        String[] keyCode = new String[52];
        String[] eKey = encript(str);
        
        int i = 51;
        int n = 0;
        for(int j = 0; j < 8; j++ ){
            String[] temp = new String[6];
            
            temp[3] = Integer.toBinaryString( mulinv(Integer.parseInt( eKey[i--], 2 )) );
            temp[2] = Integer.toBinaryString( minValue(eKey[i--]) );
            temp[1] = Integer.toBinaryString( minValue(eKey[i--]) );
            temp[0] = Integer.toBinaryString( mulinv(Integer.parseInt(eKey[i--], 2)) );
            temp[5] = eKey[i--];
            temp[4] = eKey[i--];
            
            for(String s : temp) keyCode[n++] = s;
        }
        
        String[] temp = new String[4];
        
        temp[3] = Integer.toBinaryString( mulinv(Integer.parseInt( eKey[i--], 2 )) );
        temp[2] = Integer.toBinaryString( minValue(eKey[i--]) );
        temp[1] = Integer.toBinaryString( minValue(eKey[i--]) );
        temp[0] = Integer.toBinaryString( mulinv(Integer.parseInt( eKey[i--], 2 )) );
        
        for(String s : temp) keyCode[n++] = s;
        
        return keyCode;
    }
    
    public String[] decriptEx (String str){
        String[] keyCode = new String[52];
        String[] eKey = encript(str);
        
        int i = 51;
        int n = 0;
        for(int j = 0; j < 8; j++ ){
            String[] temp = new String[6];
            
            temp[3] = Integer.toBinaryString( minValue( eKey[i--]) );
            temp[2] = Integer.toBinaryString( minValuex(eKey[i--]) );
            temp[1] = Integer.toBinaryString( minValuex(eKey[i--]) );
            temp[0] = Integer.toBinaryString( minValue( eKey[i--]) );
            temp[5] = eKey[i--];
            temp[4] = eKey[i--];
            
            for(String s : temp) keyCode[n++] = s;
        }
        
        String[] temp = new String[4];
        
        temp[3] = Integer.toBinaryString( minValue( eKey[i--]) );
        temp[2] = Integer.toBinaryString( minValuex(eKey[i--]) );
        temp[1] = Integer.toBinaryString( minValuex(eKey[i--]) );
        temp[0] = Integer.toBinaryString( minValue( eKey[i--]) );
        
        for(String s : temp) keyCode[n++] = s;
        
        return keyCode;
    }

    private String rotasi(String code) {
        String depan = code.substring(0, 25);
        String belakang = code.substring(25, 128);
        String hasil = belakang + depan;
        return hasil;
    }
    
    private static int mulinv(int x) {
        int t0, t1, q, y;
        if (x <= 1) {
            return x; // 0 dan 1 adalah inverese dirinya sendiri
        }
        t0 = 1;
        t1 = 0x10001 / x;
        y = (0x10001 % x) & 0xffff;
        for (;;) {
            if (y == 1) {
                return (1 - t1) & 0xffff;
            }
            q = x / y;
            x = x % y;
            t0 = (t0 + q * t1) & 0xffff;
            if (x == 1) {
                return t0;
            }
            q = y / x;
            y = y % x;
            t1 = (t1 + q * t0) & 0xffff;
        }
    }
    
    private int minValue(String str){
        String[] s = str.split("(?<=\\G.)");
        String[] h = new String[s.length];
        for ( int i = 0; i < s.length; i++ ) h[i] = (s[i].equals("0")) ? "1" : "0";
        int hasil = Integer.parseInt(String.join("", h), 2);
        return hasil;
    }
    
    private int minValuex(String str){
        String[] s = str.split("(?<=\\G.)");
        String[] h = new String[s.length];
        for ( int i = 0; i < s.length; i++ ) 
            if(i == 0) h[i] = (s[i].equals("0")) ? "1" : "0";
            else h[i] = s[i];
        int hasil = Integer.parseInt(String.join("", h), 2);
        return hasil;
    }
}