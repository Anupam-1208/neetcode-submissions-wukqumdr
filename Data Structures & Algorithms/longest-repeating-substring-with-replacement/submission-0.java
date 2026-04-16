class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int i = 0;
        int maxFreq = 0;
        int res = 0;
        for (int j = i;j < s.length(); j++) {
            char c = s.charAt(j);
            freq[c-'A']++;
            maxFreq = Math.max(maxFreq, freq[c-'A']);
            while ((j - i + 1) - maxFreq > k) {
                freq[s.charAt(i)-'A']--;
                i++;
            }
            res = Math.max(res, j - i + 1);

        }
        return res;
    }
}
