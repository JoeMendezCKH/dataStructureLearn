package cn.joe.d05search;

/**
 * 线性查找: 数组可以是无序的
 *
 * @author Joe
 * @create 2020/3/19 14:10
 */
public class SeaSearch {
    public static void main(String[] args) {
        // 无序数组
        int[] arr = {1, 9, 11, -1, 32, 89};
        System.out.println("target index is: "+seqSearch(arr, 11));
    }

    /**
     * 这里的线性查找是只要找到一个就返回,
     * 若想查询所有, 就放到集合中, 最后返回
     *
     * @param arr
     * @param value
     * @return
     */
    private static int seqSearch(int[] arr, int value) {
        // 逐一比对, 发现值返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
