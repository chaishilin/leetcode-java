import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    private int head;
    private int[] queue;
    private int size;
    public MyCircularQueue(int k) {
        this.head = 0;
        this.size = 0;
        this.queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        queue[getMod(head+size)] = value;
        size += 1;
        return true;
    }
    
    public boolean deQueue() {
        //从队尾出栈
        if (isEmpty()) {
            return false;
        }
        head += 1;
        size -= 1;
        return true;
    }
    
    public int Front() {
        if (size == 0) {
            return -1;
        }
        head = getMod(head);
        return queue[head];
    }
    
    public int Rear() {
        if (size == 0) {
            return -1;
        }
        return queue[getMod(head+size-1)];

    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == queue.length;
    }

    private int getMod(int value) {
        if (value >= queue.length) {
            value = value % queue.length;
        }
        return value;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

