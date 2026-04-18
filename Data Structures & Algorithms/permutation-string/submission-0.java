class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqS1 = new int[26];
        for (int i = 0; i< s1.length(); i++) {
            freqS1[s1.charAt(i)-'a']++;
        }

        for(int i = 0; i < s2.length(); i++) {
            int[] freqS2 = new int[26];
            for(int j = i; j<s2.length(); j++) {
                freqS2[s2.charAt(j)-'a']++;
                boolean match = true;
                for(int k = 0; k<26; k++) {
                    if (freqS1[k] != freqS2[k]) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }
}
