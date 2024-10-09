import java.util.ArrayDeque;
import java.util.Deque;

class MyCircularQueue {
    private int maxSize;
    Deque<Integer> deque;

    public MyCircularQueue(int k) {
        maxSize = k;
        deque = new ArrayDeque<>();
    }

    public boolean enQueue(int value) {
        if (deque.size() == maxSize) {
            return false;
        }
        deque.addLast(value);
        return true;
    }

    public boolean deQueue() {
        if (deque.isEmpty()) {
            return false;
        }
        deque.removeFirst();
        return true;
    }

    public int Front() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public int Rear() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.size() == maxSize;
    }
}
