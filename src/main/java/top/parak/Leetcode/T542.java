package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote 542. 01 矩阵
 */
public class T542 {

    /**
     * DFS错误
     */
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    ans[i][j] = dfs(mat, i, j, 0);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] mat, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length)
            return Integer.MAX_VALUE;
        if (mat[i][j] == 0)
            return k;
        else {
            return Math.min(
                    Math.min(dfs(mat, i + 1, j, k + 1), dfs(mat, i - 1, j, k + 1)),
                    Math.min(dfs(mat, i, j + 1, k + 1), dfs(mat, i, j - 1, k + 1))
            );
        }
    }

    /**
     * 高效
     * (1) 遍历数组，与0不相邻的1更新为2，记录元素的坐标
     * (2) 遍历层级深度depth=1，遍历上一次记录的坐标，若元素不与depth相邻，则更新元素值为depth+2=3，记录坐标
     * (3) 遍历层级深度depth=2，遍历上一次记录的坐标，若元素不与depth相邻，则更新元素值为depth+2=4，记录坐标
     * ...
     * (4) 重复操作，直到记录的坐标中只有一个值
     */
    public int[][] updateMatrix2(int[][] mat) {
        int height = mat.length;
        int width = mat[0].length;
        int[] coors = new int[height * width * 2];
        int index = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 1) {
                    // 与0相邻
                    if (i - 1 >= 0 && mat[i - 1][j] == 0
                    ||  j - 1 >= 0 && mat[i][j - 1] == 0
                    ||  i + 1 < height && mat[i + 1][j] == 0
                    ||  j + 1 < width && mat[i][j + 1] == 0) {
                        continue;
                    }
                    // 与0不相邻
                    mat[i][j] = 2;
                    // 记录坐标
                    coors[index++] = i;
                    coors[index++] = j;
                }
            }
        }
        int depth = 1;
        // 坐标数大于1
        while (index > 2) {
            // 记录待检查的坐标数
            int count = index;
            // 记录下一层的坐标数
            index = 0;
            for (int k = 0; k < count; k += 2) {
                int i = coors[k];
                int j = coors[k + 1];
                // 与depth相邻，值为depth+1
                if (i - 1 >= 0 && mat[i - 1][j] == depth
                ||  j - 1 >= 0 && mat[i][j - 1] == depth
                ||  i + 1 < height && mat[i + 1][j] == depth
                ||  j + 1 < width && mat[i][j + 1] == depth) {
                    continue;
                }
                // 与depth不相邻
                mat[i][j] = depth + 2;
                // 记录坐标
                coors[index++] = i;
                coors[index++] = j;
            }
            // 层级深度+1
            depth++;
        }
        return mat;
    }

}
