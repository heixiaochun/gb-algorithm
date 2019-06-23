package cn.happyhbase.geekbang.algorithm.sort;

import java.util.Arrays;

/**
 * @author heixiaochun
 * @date 2019-06-23
 */
public class QuickSort {

    public static void main(String[] args) {
        new QuickSort().sort(new int[]{10, 29, 15, 0, 100, 2990, 35, 1005, 1, 99, 22, 999});
    }

    public void sort(int[] datas) {
        quickSort(datas, 0, datas.length - 1);
        System.out.println(Arrays.toString(datas));
    }

    private void quickSort(int[] datas, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition2(datas, start, end);
        quickSort(datas, start, pivot - 1);
        quickSort(datas, pivot + 1, end);
    }

    /**
     * 非原地排序实现，额外申请了2x的内存空间
     *
     * @param datas
     * @param start
     * @param end
     * @return
     */
    private int partition1(int[] datas, int start, int end) {
        // 选取最后一个元素作为pivot
        int pivotElement = datas[end];
        int[] smallerDatas = new int[end - start + 1];
        int[] largerDatas = new int[end - start + 1];
        int j = 0;
        int k = 0;
        for (int i = start; i <= end; i++) {
            int data = datas[i];
            if (data < pivotElement) {
                smallerDatas[j++] = data;
            }
            if (data > pivotElement) {
                largerDatas[k++] = data;
            }
        }
        int pivot = start + j;
        System.arraycopy(smallerDatas, 0, datas, start, j);
        datas[pivot] = pivotElement;
        System.arraycopy(largerDatas, 0, datas, pivot + 1, k);
        System.out.println("pivot=" + (start + j) + ",arrays=" + Arrays.toString(datas));
        return pivot;
    }

    /**
     * 原地排序实现
     *
     * @param datas
     * @param start
     * @param end
     * @return
     */
    private int partition2(int[] datas, int start, int end) {
        // 选取最后一个元素作为pivot
        int pivotElement = datas[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (datas[j] < pivotElement) {
                if (i != j) {
                    int temp = datas[i];
                    datas[i] = datas[j];
                    datas[j] = temp;
                }
                i++;
            }
        }
        int temp = datas[i];
        datas[i] = pivotElement;
        datas[end] = temp;
        System.out.println("pivot=" + i + ",arrays=" + Arrays.toString(datas));
        return i;
    }

}
