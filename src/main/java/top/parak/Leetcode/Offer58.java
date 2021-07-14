package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/22 13:12
 * @apiNote 剑指 Offer 58 - II. 左旋转字符串
 */

/**
 * Problem:
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new Offer58().reverseLeftWords("abcdefg", 2));
    }

}
