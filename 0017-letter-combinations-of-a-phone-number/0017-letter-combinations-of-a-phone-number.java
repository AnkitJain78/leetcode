class Solution {
    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        return helper2("",digits);
    }
    static List<String> helper2(String pr, String up){
        if(up.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(pr);
            return ans;
        }
        List<String> total = new ArrayList<>();
        int cur = up.charAt(0) - '0';
        int x = (cur == 7 || cur == 9) ? 1 : 0;
        int y = (cur == 8 || cur == 9) ? 1 : 0;
        for(int i = (cur-2)*3; i<(cur-1)*3+x; i++){
                total.addAll(helper2(pr + (char) ('a' + i+y), up.substring(1)));
        }
        return total;
    }
}