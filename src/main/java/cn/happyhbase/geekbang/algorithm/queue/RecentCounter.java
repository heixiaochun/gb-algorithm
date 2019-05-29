package cn.happyhbase.geekbang.algorithm.queue;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author heixiaochun
 * @date 2019/5/27
 */
public class RecentCounter {

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }

    private LinkedList<Integer> queue = new LinkedList<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        int result = 0;
        queue.add(t);
        Iterator<Integer> iterator = queue.descendingIterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (t - i <= 3000) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

}