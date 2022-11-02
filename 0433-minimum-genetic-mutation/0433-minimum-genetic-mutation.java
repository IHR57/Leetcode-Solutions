class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < bank.length; i++) {
            mp.put(bank[i], i + 1);
        }
        
        if(!mp.containsKey(end))
            return -1;
        
        if(start.equals(end))
            return 0;
        
        int n = bank.length;
        int last = mp.get(end);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1000000);
        
        Arrays.fill(visited, false);
        
        if(mp.containsKey(start)) {
            q.add(mp.get(start));
            dist[mp.get(start)] = 0;
            visited[mp.get(start)] = true;
        } else {
            q.add(0);
            dist[0] = 0;
            visited[0] = true;
        }
        
        char[] genes = new char[]{ 'A', 'C', 'G', 'T' };
        
        while(!q.isEmpty()) {
            int top = q.poll();
            char[] charArray;
            if(top == 0) {
                charArray = start.toCharArray();
            } else {
                charArray = bank[top-1].toCharArray();
            }
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 4; j++) {
                    char temp = charArray[i];
                    charArray[i] = genes[j];
                    String str = String.valueOf(charArray);
                    if(mp.containsKey(str) && !visited[mp.get(str)]) {
                        visited[mp.get(str)] = true;
                        q.add(mp.get(str));
                        dist[mp.get(str)] = dist[top] + 1;
                    }
                    charArray[i] = temp;
                }
            }
        }
        
        return dist[last] == 1000000 ? -1 : dist[last];
    }
}