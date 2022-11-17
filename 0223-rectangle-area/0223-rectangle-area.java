class Solution {
    int calculateOverlap(int x1, int x2, int y1, int y2) {
        int ans = Math.min(x2, y2) - Math.max(x1, y1);
        return ans > 0 ? ans : 0;
    }
    
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaFirst = (ax2 - ax1) * (ay2 - ay1);
        int areaSecond = (bx2 - bx1) * (by2 - by1);
        int overlap = calculateOverlap(ax1, ax2, bx1, bx2) * calculateOverlap(ay1, ay2, by1, by2);
        
        return areaFirst + areaSecond - overlap;
    }
}