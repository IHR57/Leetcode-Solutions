public class Solution {
    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }
    
    public int distance(int[] p, int[] q) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    private static int[] getInitialPoint(int[][] points) {
        int[] initialPoint = points[0];
        for (int[] p: points)
            if (p[1] < initialPoint[1])
                initialPoint = p;
        
        return initialPoint;
    }
    
    public int[][] outerTrees(int[][] points) {
        if (points.length <= 1)
            return points;
        
        int[] start = getInitialPoint(points);
        
        Arrays.sort(points, new Comparator<int[]> () {
            public int compare(int[] p, int[] q) {
                double diff = orientation(start, p, q) - orientation(start, q, p);
                if (diff == 0)
                    return distance(start, p) - distance(start, q);
                else
                    return diff > 0 ? 1 : -1;
            }
        });
        
        int i = points.length - 1;
        while (i >= 0 && orientation(start, points[points.length - 1], points[i]) == 0)
            i--;
        for (int l = i + 1, h = points.length - 1; l < h; l++, h--) {
            int[] temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        Stack<int[]> stack = new Stack<> ();
        stack.push(points[0]);
        stack.push(points[1]);
        
        for (int j = 2; j < points.length; j++) {
            int[] top = stack.pop();
            while (orientation(stack.peek(), top, points[j]) > 0)
                top = stack.pop();
            stack.push(top);
            stack.push(points[j]);
        }
        
        return stack.toArray(new int[stack.size()][]);
    }
}