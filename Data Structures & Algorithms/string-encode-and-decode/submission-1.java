class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i += 1) {
            String s = strs.get(i);
            String s_len = "";
            Integer len = s.length();
            if (len < 100) {
                s_len += "0";
            }
            if (len < 10) {
                s_len += "0";
            }
            s_len += len.toString();
            sb.append(s_len);
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> strArray = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int s_len = Integer.parseInt(str.substring(i, i + 3));
            i += 3;
            String s = str.substring(i, i + s_len);
            i += s_len;
            strArray.add(s);
        }
        return strArray;
    }
}
