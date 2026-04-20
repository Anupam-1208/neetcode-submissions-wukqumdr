class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            int j = 0;
            int minLen = Math.min(w1.length(), w2.length());
            
            for (; j < minLen; j++) {
                int c1 = map[w1.charAt(j) - 'a'];
                int c2 = map[w2.charAt(j) - 'a'];

                if (c1 < c2) break;          // correct order, move to next word
                if (c1 > c2) return false;   // wrong order
            }
            
            // If we reached the end of the shorter word without breaking,
            // it means w2 is a prefix of w1 or they are identical.
            // In this case, w1 cannot be longer than w2.
            if (j == minLen && w1.length() > w2.length()) {
                return false;
            }
        }
        
        return true;
    }
}