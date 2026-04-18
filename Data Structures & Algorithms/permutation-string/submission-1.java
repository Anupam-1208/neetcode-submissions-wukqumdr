class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        for (int i = 0; i< s1.length(); i++) {
            freqS1[s1.charAt(i)-'a']++;
        }
        int l = 0;
        int r = s1.length() -1;
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] freqS2 = new int[26];
        for(int i = 0; i <= r; i++) {
            freqS2[s2.charAt(i)-'a']++;
        }


        while (r < s2.length()) {
            boolean match = true;
            for(int i = 0; i<26; i++) {
                if(freqS1[i] != freqS2[i]) {
                    match = false;
                    break;
                }
                
            }
            if (match) return true;    
            freqS2[s2.charAt(l)-'a']--;
            l++;
            r++;
            if (r < s2.length())freqS2[s2.charAt(r)-'a']++;
        }
        return false;
    }
}
