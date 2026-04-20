class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 5 , 10 , 5 , 5, 20
        // 5 , if 5 take the note 
        // 10, check if 5 available, add 10
        // 20, check if 10 available 
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for(int b: bills) {
            if (b == 5) {
                count5++;
            }
            if (b == 10) {
                if (count5 < 1) {
                    return false;
                }
                count10++;
                count5--;
            }
            if (b == 20) {
                if (count10 < 1) {
                    if (count5 < 3) {
                        return false;
                    }
                    count5 -= 3;

                } else {
                    if (count5 < 1) {
                        return false;
                    }
                    count10--;
                    count5--;
                }
            }
        }
        return true;
    }
}