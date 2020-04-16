package cn.joe.d01sparsearray;

import java.io.*;

/**
 * @author Joe
 * @create 2020/3/4 22:11
 * <p>
 * 稀疏数组的处理方法是:
 * 1. 记录数组一共有几行几列，有多少个不同的值
 * 2. 把具有不同值的元素的行列及值记录在一个小规模的数组中，从而缩小程序的规模
 */
public class SparseArray {

    public static void main(String[] args) {
        // 1 black  2 write
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[4][7] = 1;
        chessArr1[2][4] = 2;
        chessArr1[5][4] = 2;
        chessArr1[3][4] = 1;
        // primary 2-dimensional array
        printArr(chessArr1);

        // get the nonzero nums
        int sum = 0;
        for (int[] row : chessArr1) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
            }
        }

        // create sparse array
        int[][] sparseArr = new int[sum + 1][3];
        // init the sparseArr
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("sparse arr is =========");
        printArr(sparseArr);

        int[][] result = null;
        try {
            writeFile(sparseArr);
            System.out.println("save to a file");
            result = readFile(new File("map.data"));
            System.out.println("read the file over");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result == null) { throw new AssertionError(); }
        // recover sparse array
        int[][] chessArr2 = new int[result[0][0]][result[0][1]];
        for (int i = 1; i <= sparseArr[0][2]; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("recover array is =========");
        printArr(chessArr2);
    }

    private static void writeFile(int[][] sparseArr) throws IOException {
        File file = new File("map.data");

        FileWriter fw = new FileWriter(file);
        for (int[] row : sparseArr) {
            for (int data : row) {
                fw.write(data + "\t");
            }
            fw.write("\r");
        }
        fw.close();
    }

    private static int[][] readFile(File file) throws IOException {
        int[][] result = null;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String s = br.readLine();
        if (s == null) { throw new AssertionError(); }
        String[] split = s.split("\t");
        result = new int[Integer.parseInt(split[2]) + 1][3];

        result[0][0] = Integer.parseInt(split[0]);
        result[0][1] = Integer.parseInt(split[1]);
        result[0][2] = Integer.parseInt(split[2]);

        int i = 1;
        while ((s = br.readLine()) != null) {
            split = s.split("\t");
            result[i][0] = Integer.parseInt(split[0]);
            result[i][1] = Integer.parseInt(split[1]);
            result[i][2] = Integer.parseInt(split[2]);
            i++;
        }
        br.close();
        return result;
    }

    private static void printArr(int[][] sparseArr) {
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
