class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(mp.containsKey(words[i])) {
                mp.put(words[i], mp.get(words[i]) + 1);
            } else {
                mp.put(words[i], 1);
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                 (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            ans.add(0, pq.poll().getKey());
        }
        
        return ans;
    }
}