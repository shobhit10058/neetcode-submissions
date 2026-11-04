class Solution {
    public boolean isAlphanumeric(char c) {
        if ((c >= 'A') && (c <= 'Z')) {
            return true;
        }
        if ((c >= 'a') && (c <= 'z')) {
            return true;
        }
        return (c >= '0') && (c <= '9');
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (!isAlphanumeric(s.charAt(r))) {
                r --;
                continue;
            }
            if (!isAlphanumeric(s.charAt(l))) {
                l ++;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
}
