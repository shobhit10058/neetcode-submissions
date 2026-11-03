class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < (int)(s.length()) - 1; i += 1) {
            char c = s.charAt(i);
            char cAdj = s.charAt(i + 1);
            score += Math.abs(c - cAdj);
        }
        return score;
    }
}