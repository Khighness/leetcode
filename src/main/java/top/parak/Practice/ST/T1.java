package top.parak.Practice.ST;

/**
 * @author KHighness
 * @since 2021-08-11
 */
public class T1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 图像旋转
     * @param img int整型二维数组 输入图像
     * @return int整型二维数组
     */
    public int[][] rotate_img (int[][] img) {
        // write code here
        int n = img.length;
        if (n == 0) return img;
        // 左上角区域最大行下标
        int r = (n >> 1) - 1;
        // 左上角区域最大列下标
        int c = (n - 1) >> 1;
        for (int i = r; i >= 0; i--) {
            for (int j = c; j >= 0; j--) {
                swap(img, i, j, j, n - i - 1);
                swap(img, i, j, n - i - 1, n - j - 1);
                swap(img, i, j, n - j - 1, i);
            }
        }
        return img;
    }

    private void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
