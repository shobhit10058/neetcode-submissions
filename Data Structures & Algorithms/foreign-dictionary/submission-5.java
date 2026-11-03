class Solution {
    private List<List<Integer>> graph;
    private int[] indegree;
    private int N;
    private HashSet<Integer> uniqueChars;

    public Solution() {
        graph = null;
    }

    public int getFirstMismatch(String a, String b) {
        int nA = a.length();
        int nB = b.length();
        int nMin = Math.min(nA, nB);
        int found = -1;
        for (int i = 0; i < nMin; i += 1) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return -1;
    }

    public void processDirectedEdge(int a, int b) {
        List<Integer> aNei = graph.get(a);
        if (aNei == null) {
            aNei = new ArrayList<>();
            graph.set(a, aNei);
        }
        aNei.add(b);
        indegree[b] += 1;
    }

    public List<Integer> doTopoSort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i += 1) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        List<Integer> topSorted = new ArrayList<>();
        while (!q.isEmpty()) {
            int tp = q.poll();
            topSorted.add(tp);
            if (graph.get(tp) == null) {
                continue;
            }
            for (int nei: graph.get(tp)) {
                indegree[nei] -= 1;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        // System.out.println(topSorted + " , size =" + topSorted.size());
        if (topSorted.size() == N) {
            return topSorted;
        }
        return null;
    }

    public String foreignDictionary(String[] words) {
        int n = words.length;
        graph = new ArrayList<>(Collections.nCopies(26, null));
        indegree = new int[26];
        N = 26;
        uniqueChars = new HashSet<>();
        for (int i = 0 ; i < words.length - 1; i += 1) {
            int misIdx = getFirstMismatch(words[i], words[i + 1]);
            if (misIdx != -1) {
                processDirectedEdge(words[i].charAt(misIdx) - 'a', words[i + 1].charAt(misIdx) - 'a');
            } else if (words[i].length() > words[i + 1].length()) {
                return "";
            }
            for (char c: words[i].toCharArray()) {
                uniqueChars.add(c - 'a');
            }
        }
        for (char c: words[n - 1].toCharArray()) {
            uniqueChars.add(c - 'a');
        }
        // System.out.println(graph);
        // System.out.println(Arrays.toString(indegree));
        List<Integer> tpSorted = doTopoSort();
        // System.out.println(tpSorted);
        if (tpSorted == null) {
            return "";
        }
        StringBuilder sol = new StringBuilder();
        for (int ch: tpSorted) {
            if (uniqueChars.contains(ch)) {
                sol.append((char) (ch + 'a'));
            }
        }
        // System.out.println(sol);
        return sol.toString();
    }
}
