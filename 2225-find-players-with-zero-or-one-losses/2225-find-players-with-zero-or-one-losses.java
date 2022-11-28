class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> values = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            values.put(matches[i][0], 1);
            values.put(matches[i][1], 1);
            
            counter.put(matches[i][0], counter.containsKey(matches[i][0]) ? counter.get(matches[i][0]) : 0);
            counter.put(matches[i][1], counter.containsKey(matches[i][1]) ? counter.get(matches[i][1]) + 1 : 1);
            
        }
        
        for(Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if(entry.getValue() == 0) {
                list1.add(entry.getKey());
            } else if(entry.getValue() == 1) {
                list2.add(entry.getKey());
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        result.add(list1);
        result.add(list2);
        
        return result;
    }
}