class RandomizedSet {
public:
    /** Initialize your data structure here. */
    vector<int>arr;
    
    RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    bool insert(int val) {
        for(int i = 0; i < arr.size(); i++)
            if(arr[i] == val)  return false;
        
        arr.push_back(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    bool remove(int val) {
        for(int i = 0; i < arr.size(); i++)
        {
            if(arr[i] == val)
            {
                arr.erase(arr.begin()+i);
                return true;
            }
        }
        return false;
    }
    
    /** Get a random element from the set. */
    int getRandom() {
        return arr[rand() % arr.size()];   
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */