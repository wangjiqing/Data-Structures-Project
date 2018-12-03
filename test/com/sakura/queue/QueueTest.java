package com.sakura.queue;

import com.sakura.queue.impl.ArrayQueueImpl;
import com.sakura.stack.impl.LoopQueueImpl;

public class QueueTest {

    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public void testLookQueue() {
        Queue<Integer> queue = new LoopQueueImpl<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public static void main(String[] args) {
        new QueueTest().testArrayQueue();

        new QueueTest().testLookQueue();
    }
}
