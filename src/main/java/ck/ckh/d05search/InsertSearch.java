package ck.ckh.d05search;

/**
 * @author Joe
 * @create 2020/3/19 14:46
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 2;
        }

        System.out.println(insertSearch(arr, 0, arr.length - 1, 40));

    }

    /**
     *
     */
    private static int insertSearch(int[] arr, int left, int right, int value) {
        System.out.println("asdf");
        // 保证 mid 不越界, 必须有
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];

        if (value > midValue) {
            return insertSearch(arr, mid + 1, right, value);
        } else if (value < midValue) {
            return insertSearch(arr, left, mid - 1, value);
        } else {
            return mid;
        }

    }
}
