class Solution {
    final char SEPARATOR = '#';

    public String encode(List<String> strs) {
        String encodedString = "";
        for (String str: strs) {
            encodedString += String.valueOf(str.length());
            encodedString += SEPARATOR;
            encodedString += str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        int encodedLength = str.length();
        String currStringLength = "";
        List<String> ans = new ArrayList<>();
        boolean strStart = false;
        for (int i = 0; i < encodedLength; i += 1) {
            char c = str.charAt(i);
            if (c != SEPARATOR) {
                currStringLength += c;
            } else {
                i += 1;
                int stringLength = Integer.valueOf(currStringLength);
                ans.add(str.substring(i, i + stringLength));
                i += stringLength - 1;
                currStringLength = "";
            }
        }
        return ans;
    }
}
