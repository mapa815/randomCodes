/*
PROBLEM STATEMENT

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:
LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
*/
class LRUCache {
    private Map<Integer, ListNode> nodes;
    private int capacity = 0;
    private ListNode head;
    private ListNode tail;
    
    public LRUCache(int capacity) {
        this.nodes = new HashMap();
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1, head, null);
        head.next = this.tail;
    }
    
    public int get(int key) {
        if(this.nodes.containsKey(key)) {
            ListNode node = this.nodes.get(key);
            
            this.moveToHead(node);
            
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.nodes.containsKey(key)) {
            ListNode node = this.nodes.get(key);
            node.val = value;
            
            this.moveToHead(node);
        } else {
            if(this.nodes.size() == this.capacity) {
                this.nodes.remove(this.tail.prev.key);
                
                this.tail.prev.prev.next = tail;
                tail.prev = this.tail.prev.prev;
            }
            
            ListNode node = new ListNode(key, value, this.head, this.head.next);
                
            this.head.next.prev = node;
            this.head.next = node;
            
            this.nodes.put(key, node);
        }
    }
    
    private void moveToHead(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = this.head;
        node.next = this.head.next;

        this.head.next.prev = node;

        this.head.next = node;
    }
    
    private class ListNode {
        public int val;
        public int key;
        public ListNode next = null;
        public ListNode prev = null;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        
        public ListNode(int key, int val, ListNode prev, ListNode next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
