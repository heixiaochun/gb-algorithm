package cn.happyhbase.geekbang.algorithm.search;

/**
 * @author heixiaochun
 * @date 2019-06-29
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] datas = new int[]{10, 22, 33, 50, 60, 70, 80, 90, 99, 100, 155, 200, 255, 300, 1005, 2005, 30000, 2003556};
        System.out.println(new BinarySearch().search(datas, 30000));
        System.out.println(new BinarySearch().search(datas, 990));

        int[] datas2 = new int[]{1, 4, 7, 9, 10, 12, 17, 20};
        System.out.println(new BinarySearch().search(datas2, 0));
        System.out.println(new BinarySearch().search(datas, 4));
    }

    public int search(int[] datas, int target) {
        int startIndex = 0;
        int endIndex = datas.length - 1;
        while (endIndex >= startIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            System.out.println("startIndex: " + startIndex + ", endIndex: " + endIndex + ", middleIndex: " + middleIndex);
            int middle = datas[middleIndex];
            if (middle == target) {
                return middleIndex;
            }
            if (middle < target) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }
        return startIndex;
    }

}
