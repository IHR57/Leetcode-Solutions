#define MAX 800005
class MedianFinder {
public:
    /** initialize your data structure here. */

    priority_queue<int> heapMax;
    priority_queue<int,vector<int>,greater<int>> heapMin;
    
    MedianFinder() {

    }
    
    void addNum(int num) {
        if(heapMax.empty() || (!heapMax.empty() && num <= heapMax.top()))
            heapMax.push(num);
        else
            heapMin.push(num);
        
        int d = heapMax.size() - heapMin.size();
        
        if(d > 1) {
            heapMin.push(heapMax.top());
            heapMax.pop();
        }
        else if(d < 0) {
            heapMax.push(heapMin.top());
            heapMin.pop();
        }
    }
    
    double findMedian() {
        if(heapMax.size() == heapMin.size()) {
            double ans = ((double) heapMax.top() + (double) heapMin.top()) / 2.0;
            return ans;
        }
        else {
            return heapMax.top();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */