class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int x: nums) {
            mp.compute(x, (key, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (Map.Entry<Integer, Integer> entry: mp.entrySet()) {
            pq.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        ArrayList<Integer> arrayList = new ArrayList<>(26);
        for (int i = 0; i < k; i += 1) {
            arrayList.add(pq.poll()[1]);       
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
