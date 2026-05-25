class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a map
        Map<Integer, Integer> map = new HashMap<>();

        // iterate over the nums
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create a max heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> a.getValue() - b.getValue()
        );

        // iterate over the map
        for (Map.Entry<Integer, Integer> num: map.entrySet()) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }


        int[] output = new int[k]; 
        for (int i = 0; i < k; i++) {
            output[i] = pq.poll().getKey();
        }
        return output;
    }
}
