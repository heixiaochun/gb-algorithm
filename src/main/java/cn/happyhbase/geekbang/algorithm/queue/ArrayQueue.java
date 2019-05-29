package cn.happyhbase.geekbang.algorithm.queue;

/**
 * queue based on fixed size array
 *
 * @author heixiaochun
 * @date 2019/5/27
 */
public class ArrayQueue {

    /**
     * 内部数组对象
     */
    private String[] stringArray = null;

    /**
     * 数组大小
     */
    private int size = 0;

    /**
     * 当前队列大小
     */
    private int count = 0;

    public ArrayQueue(int size) {
        this.size = size;
        stringArray = new String[size];
    }

    /**
     * 插入队尾
     *
     * @param element
     */
    public void enqueue(String element) {
        if (count >= size - 1) {
            throw new IllegalStateException("queue full");
        }
        stringArray[count] = element;
        count++;
    }

    /**
     * 队首元素出列
     *
     * @return
     */
    public String dequeue() {
        if (count == 0) {
            throw new IllegalStateException("queue empty");
        }
        String headElement = stringArray[0];
        String[] newArray = new String[size];
        System.arraycopy(stringArray, 1, newArray, 0, count);
        stringArray = newArray;
        count--;
        return headElement;
    }

    public int getQueueSize(){
        return count;
    }

}
