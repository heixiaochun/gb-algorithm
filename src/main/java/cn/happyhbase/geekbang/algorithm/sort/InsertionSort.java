package cn.happyhbase.geekbang.algorithm.sort;

import java.util.Arrays;

/**
 * @author heixiaochun
 * @date 2019/5/29
 */
public class InsertionSort {

    public static void main(String[] args) {
        new InsertionSort().sort(new int[]{1});
        new InsertionSort().sort(new int[]{1, 2});
        new InsertionSort().sort(new int[]{1, 2, 3});
        new InsertionSort().sort(new int[]{1, 2, 3, 4});
        new InsertionSort().sort(new int[]{1, 2, 3, 4, 5});
        new InsertionSort().sort(new int[]{1, 1});
        new InsertionSort().sort(new int[]{1, 2});
        new InsertionSort().sort(new int[]{2, 1});
        new InsertionSort().sort(new int[]{1, 1, 1});
        new InsertionSort().sort(new int[]{1, 2, 1});
        new InsertionSort().sort(new int[]{3, 2, 1});
        new InsertionSort().sort(new int[]{5, 4, 3, 2, 1});
        new InsertionSort().sort(new int[]{10, 29, 10, 0, 100, 2990, 10, 1005, 0, 10, 22, 999});
    }

    /**
     * 讲datas中的数据使用插入排序从小到大排列
     *
     * @param datas
     */
    public void sort(int[] datas) {
        if (datas == null || datas.length <= 1) {
            return;
        }
        int len = datas.length;
        // 从第二个元素开始，进行比较与插入操作
        for (int i = 1; i < len; i++) {
            // 需要插入的元素
            int target = datas[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (target < datas[j]) {
                    datas[j + 1] = datas[j];
                } else {
                    break;
                }
            }
            datas[j + 1] = target;
        }
        System.out.println(Arrays.toString(datas));
    }

}
