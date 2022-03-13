public class MultiplyStrings {

    String multiply(String a, String b) {
        String[] result = new String[a.length()*b.length()];
        int k = (a.length()*b.length())-1;
        while(a.length()<b.length()) {
            return multiply(b,a);
        }
        
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        
        for(;i >= 0; i--) {
            int prod = (a.charAt(i) - '0') *( b.charAt(j)-'0');
            result[k] = String.valueOf(prod%10 + carry);
            carry = prod/10;
            result[k-1] = String.valueOf(carry);
            k--;
        }
        StringBuffer results = new StringBuffer();
        for (String s: result) {
            results.append(s);
        }
        return results.toString();
    }
    public static void main(String[] args) {
        String a = "2355" ;
        String b = "565";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String prod = multiplyStrings.multiply(a, b);
        System.out.println(prod);
      
    }
}
