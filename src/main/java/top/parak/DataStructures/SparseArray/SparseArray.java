package top.parak.DataStructures.SparseArray;

/**
 * @author KHighness
 * @since 2020-08-26
 * @apiNote 稀疏数组
 */
public class SparseArray {

    /**
     * 稀疏数组->原始数组
     * 1、先读取稀疏数组的第一行，根据第一行的数据，创建原始二维数组
     * 2、再读取稀疏数组后几行的数据，并赋值给原始的二维数组
     */
    public static void main(String[] args) {

        // 创建原始的二维数组
        int array[][] = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;

        System.out.println("原始二维数组");
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        /* 压缩数组 */

        // 获取有效数据数量
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 创建对应的稀疏数组
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 遍历二维数组，非零数值存入稀疏数组
        int index = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (array[i][j] != 0) {
                    index++;
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = array[i][j];
                }
            }
        }

        System.out.println("压缩稀疏数组");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[1][2]);
        }

        /* 还原数组 */

        // 创建还原数组
        int array2[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sum+1; i++) {
                array2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];

        }

        System.out.println("还原二维数组");
        for (int[] row : array2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
