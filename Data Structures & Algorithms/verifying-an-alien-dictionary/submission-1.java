class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < order.length(); i++) {
            map[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            
            for (int j = 0; j < w1.length(); j++) {
                if (j == w2.length()) {
                    return false;
                }
                int c1 = map[w1.charAt(j) - 'a'];
                int c2 = map[w2.charAt(j) - 'a'];

                if (c1 < c2) break;          // correct order, move to next word
                if (c1 > c2) return false;   // wrong order
            }
            
        }
        
        return true;
    }
}