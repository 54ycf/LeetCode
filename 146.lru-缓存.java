import java.util.HashMap;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    class DQueue{
        int key;
        int val;
        DQueue prev;
        DQueue next;
        public DQueue(){};
        public DQueue(int key, int val){this.key=key; this.val=val;}
    }
    int capacity;
    int size;
    Map<Integer, DQueue> cache;
    DQueue head = new DQueue();
    DQueue tail = new DQueue();


    public LRUCache(int capacity) {
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DQueue node = cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DQueue node = cache.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
        }else{
            node = new DQueue(key, value);
            cache.put(key,node);
            addToHead(node);
            ++size;
            if(size > capacity){
                cache.remove(removeTail().key);
                --size;
            }
        }
    }

    private void moveToHead(DQueue node){
        remove(node);
        addToHead(node);
    }

    private void addToHead(DQueue node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(DQueue node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DQueue removeTail(){
        DQueue node = tail.prev;
        remove(node);
        return node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

