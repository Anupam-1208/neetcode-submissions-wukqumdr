class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
         // set of character
        // add to the set when new value found
        // if repeated remove from set, a
        // 
        boolean[] in = new boolean[256];
        int maxLen = 0;
        int i = 0;
        for (int j = 0;j < s.length(); j++) {
            char c = s.charAt(j);
            while (in[c]) {
                in[s.charAt(i)] = false;
                i++;
            }
            in[c] = true;
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
