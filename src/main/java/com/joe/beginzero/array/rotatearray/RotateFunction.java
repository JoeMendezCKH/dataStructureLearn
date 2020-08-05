package com.joe.beginzero.array.rotatearray;

/**
 * 396. Rotate Function
 * <p>
 * just use the mathematic
 *
 * @author ckh
 * @create 2020/8/5 9:40
 */
public class RotateFunction {

    public int maxRotateFunction(int[] A) {
        int size = A.length;
        long sum = 0, temp = 0;

        for (int i = 0; i < size; i++) {
            sum += A[i];
            // F[k]
            temp += i * A[i];
        }

        long res = temp;
        for (int i = size - 1; i >= 0; --i) {
            // F(k+1) = F(k) + S - n * Bk[n-1]
            temp += sum - size * (long) A[i];
            res = Math.max(res, temp);
        }
        return (int) res;

    }
}
