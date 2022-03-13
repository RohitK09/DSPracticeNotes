class CountPalindarome {
    public int countSubstrings(String s) {
        //count even number of palindromes
        int l = 0;
        int r =0;
        int count =0;
        for (int i =0; i< s.length(); i++) {
            l=i;
            r =l;
            while(l>=0 && r < s.length() && l<=r) {
            if(s.charAt(l)==s.charAt(r)) {
                count++;
                l--;
                r++;
            } else {
                break;
                }
            }
        }
        //count odd number of palindromes 
        for (int i =0; i< s.length(); i++) {
            l=i;
            r =l+1;
            while(l>=0 && r < s.length() && l<r) {
            if(s.charAt(l)==s.charAt(r)) {
                count++;
                l--;
                r++;
            } else {
                break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountPalindarome  ct = new CountPalindarome();
        ct.countSubstrings("abc");
        System.out.println(ct.countSubstrings("abc"));
    }
}