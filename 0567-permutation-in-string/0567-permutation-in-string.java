class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < s1.length(); i++){
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        int start = 0;
        int end = s1.length() - 1;
        while(end<s2.length()){
            if(match(a,b))
                return true;
            b[s2.charAt(start) - 'a']--;
            start++;
            end++;
            if(end==s2.length())
                return false;
            b[s2.charAt(end) - 'a']++;
        }
        return false;
    }
    
    static boolean match(int[] a, int[] b){
        for(int i = 0; i < 26; i++){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}