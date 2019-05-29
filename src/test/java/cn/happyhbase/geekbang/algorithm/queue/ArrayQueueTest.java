package cn.happyhbase.geekbang.algorithm.queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author heixiaochun
 * @date 2019/5/27
 */
public class ArrayQueueTest {

    @Test
    public void testArrayQueue() {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        Assert.assertEquals("a", queue.dequeue());
        Assert.assertEquals("b", queue.dequeue());
        Assert.assertEquals("c", queue.dequeue());
        Assert.assertEquals("d", queue.dequeue());
        Assert.assertEquals("e", queue.dequeue());
        Assert.assertEquals(0, queue.getQueueSize());
    }

}
