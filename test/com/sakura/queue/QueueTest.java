package com.sakura.queue;

import com.sakura.queue.impl.ArrayQueueImpl;
import com.sakura.stack.impl.LoopQueueImpl;

import java.util.Random;

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

    /**
     * 测试队列效率
     */
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

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        new QueueTest().testArrayQueue();
//        new QueueTest().testLookQueue();

        int opCount = 100000;
        Queue<Integer> q1 = new ArrayQueueImpl<>();
        double time1 = testQueue(q1, opCount);

        Queue<Integer> q2 = new LoopQueueImpl<>();
        double time2 = testQueue(q2, opCount);

        System.out.println(time1);
        System.out.println(time2);
    }
}
