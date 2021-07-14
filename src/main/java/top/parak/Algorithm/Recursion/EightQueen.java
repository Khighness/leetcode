package top.parak.Algorithm.Recursion;

/**
 * @author KHighness
 * @date 2020/8/29 10:06
 * @apiNote 八皇后
 */

public class EightQueen {

    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.putQueen(0);
        System.out.printf("|♛| 总判断次数为【%d】\n", check);
        System.out.printf("|♛| 八皇后摆放方式为【%d】", sum);
    }

    // 常量：表示皇后个数
    static int COUNT = 8;

    // 一位数组存放皇后摆放位置
    static int[] array = new int[COUNT];

    // 记录摆放方案
    static int sum = 0;

    // 判断次数
    static int check = 0;

    /**
     * 放置皇后
     * @param n 第n个皇后
     */
    private void putQueen(int n) {
        if (n == COUNT) { // 所有皇后放置完毕
            sum++;
            printPlace();
            return;
        } else {
            for (int i = 0; i < COUNT; i++) {
                array[n] = i;
                if (checkPlace(n)) { // 不冲突继续放第n+1个皇后
                    putQueen(n+1);
                } // 冲突则当前皇后放到i++后的位置
            }
        }
    }

    /**
     * 检测是否冲突
     * @param n 第n个皇后
     * @return
     */
    private boolean checkPlace(int n) {
        for (int i = 0; i < n; i++) {
            check++;
            // 1、检测是否同列
            // 2、检测是否同对角线
            if (array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后位置
     */
    private void printPlace() {
        System.out.printf("▶ %d、八皇后摆放位置：", sum);
        for (int i = 0; i < COUNT; i++) {
            System.out.print(array[i] + 1 + " ");
        }
        System.out.println("\n▶ 摆放位置如下：");
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                System.out.print("---");
            }
            System.out.println();
            for (int k = 0; k < COUNT; k++) {
                if (k == array[i]) {
                    System.out.print("|" + "♛");
                } else {
                    System.out.print("|" + "  ");
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < COUNT; i++) {
            System.out.print("---");
        }
        System.out.println();
    }

}
