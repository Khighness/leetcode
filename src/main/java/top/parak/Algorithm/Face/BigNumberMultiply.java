package top.parak.Algorithm.Face;

/**
 * @author KHighness
 * @since 2021-09-15
 * @apiNote 大数乘法
 */
public class BigNumberMultiply {

    /**
     * 两个大数相乘
     *
     * @param str1 数值字符串1
     * @param str2 数值字符串2
     * @return 相乘结果
     */
    public static String multiply(String str1,String str2){
        // 转成字符数组，数组下标越小，对应位数越高
        char[] cs1 = str1.toCharArray(), cs2 = str2.toCharArray();
        int[] result = new int[cs1.length + cs2.length];

        // 直接相乘t
        for (int i = 0; i < cs1.length; i++) {
            for (int j = 0; j < cs2.length; j++) {
                result[i + j] += (cs1[i] - '0') * (cs2[j] - '0');
            }
        }

        // 处理进位
        // 从低位至高位，需要逆序处理
        int temp;
        for (int k = result.length - 1; k > 0; k--) {
            temp = result[k] / 10;
            result[k - 1] += temp;
            result[k] = result[k] % 10;
        }

        // 拼接结果
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++){
            builder.append(result[i]);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("1524155677489", "1524155677489"));
    }
}
