package top.parak.Algorithm.Recursion;

/**
 * @author KHighness
 * @since 2020-08-29
 * @apiNote 迷宫问题
 */
public class Maze {

    /**
     * 递归回溯寻找通路
     * 1、map表示地图
     * 2、(i, j)表示从地图的哪个位置出发
     * 3、如果小球到达map[6][5]，则说明通路找到
     * 4、约定：
     *    map=0：没走过；
     *    map=1：表示墙
     *    map=2：表示通路可以走
     *    map=3：表示该点已经走过，但是走不通
     * 5、走迷宫时，需要确定一个策略【下->右->上->左】
     *    如果该点走不通，再回溯
     * @param map
     * @param i
     * @param j
     * @return 找到通路返回true，否则返回false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                // 如果当前这个点还没有走过
                // 走策略：【下->右->上->左】
                map[i][j] = 2; // 假定该点可以走通
                if (setWay(map, i+1, j)) {
                    // 向下走
                    return true;
                } else if (setWay(map, i, j+1)) {
                    // 向右走
                    return true;
                } else if (setWay(map, i-1, j)) {
                    // 向上走
                    return true;
                } else if (setWay(map, i , j-1)){
                    // 向左走
                    return true;
                } else {
                    // 上下左右都走不通，即该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // map=1: 表示墙，走不通
                // map=3：已经走过，不通
                return false;
            }
        }
    }

    // 修改找路策略：上->右->下->左
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 通路已经找到
            return true;
        } else {
            if (map[i][j] == 0) {
                // 如果当前这个点还没有走过
                // 走策略：【下->右->上->左】
                map[i][j] = 2; // 假定该点可以走通
                if (setWay2(map, i-1, j)) {
                    // 向上走
                    return true;
                } else if (setWay2(map, i, j+1)) {
                    // 向右走
                    return true;
                } else if (setWay2(map, i+1, j)) {
                    // 向下走
                    return true;
                } else if (setWay2(map, i , j-1)){
                    // 向左走
                    return true;
                } else {
                    // 上下左右都走不通，即该点走不通，死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                // map=1: 表示墙，走不通
                // map=3：已经走过，不通
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 上下全部置为1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[2][4] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        // 输出地图
        System.out.println("迷宫地图如下");
        for (int[] row : map) {
            for (int i  : row) {
                if (i == 1) {
                    System.out.print("■\t");
                    continue;
                }
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }

        // 递归找路
        setWay2(map, 1, 1);

        // 输出新的地图
        System.out.println("小球走完后标识的地图");
        for (int[] row : map) {
            for (int i  : row) {
                if (i == 1) {
                    System.out.print("■\t");
                } else if (i == 2) {
                    System.out.print("●\t");
                } else {
                    System.out.printf("%d\t", i);
                }
            }
            System.out.println();
        }
    }

}
