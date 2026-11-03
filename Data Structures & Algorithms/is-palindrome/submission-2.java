class Solution {
    private int charType(char c) {
        if ((c >= 'a') && (c <= 'z')) {
            return 1;
        }
        if ((c >= 'A') && (c <= 'Z')) {
            return 2;
        }
        if ((c >= '0') && (c <= '9')) {
            return 3;
        }
        return 4;
    }

    public boolean isPalindrome(String s) {
        int n = s.length(), l = 0, r = n - 1;
        while (l < r) {
            char cL = s.charAt(l);
            char cR = s.charAt(r);

            int cLType = charType(cL);
            int cRType = charType(cR);

            if (cLType == 4) {
                l += 1;
                continue;
            }
            
            if (cRType == 4) {
                r -= 1;
                continue;
            }

            if (cLType == 2) {
                cL = (char) ('a' + (cL - 'A'));
            }

            
            if (cRType == 2) {
                cR = (char) ('a' + (cR - 'A'));
            }

            if (cL != cR) {
                return false;
            }

            l += 1;
            r -= 1;
        }

        return true;
    }
}
