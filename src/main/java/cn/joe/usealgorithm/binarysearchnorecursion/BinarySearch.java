package cn.joe.usealgorithm.binarysearchnorecursion;

/**
 * @author Joe
 * @create 2020/4/20 13:40
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 10, 12, 34, 45, 100};
        System.out.println(binarySearch(arr, 45));
    }

    /**
     * 非递归的二分查找
     *
     * @param arr    数组, 升序排列
     * @param target 目标值
     * @return 在数组中的索引
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
