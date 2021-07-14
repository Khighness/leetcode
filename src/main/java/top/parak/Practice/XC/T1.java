package top.parak.Practice.XC;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-06-10
 */

public class T1 {
    static String unwangdulize(String word) {
        List<String> prevs = new ArrayList<>();
        List<String> posts = new ArrayList<>();
        // process prev
        int len = word.length(), left = 0, right = 2;
        while (right <= len) {
            String prev = word.substring(left, right);
            if (prev.equals("anti") || prev.equals("post") || prev.equals("pre") || prev.equals("re") || prev.equals("un")) {
                prevs.add(prev);
                word = word.substring(right);
                len = word.length();
                left = right;
                right += 2;
            } else right++;
        }

        // process post
        len = word.length(); left = len - 2; right = word.length();
        while (left >= 0) {
            String post = word.substring(left, right);
            if (post.equals("er") || post.equals("ing") || post.equals("ize") || post.equals("tion") || post.equals("ful")) {
                posts.add(post);
                word = word.substring(0, left);
                right = left;
                left -= 2;
            } else left--;
        }
        // last process
        Collections.reverse(posts);
        StringBuilder sb1 = new StringBuilder(word);
        for (String post : posts) {
            if (post.equals("er")) sb1 = new StringBuilder(" one who " + sb1 + "s");
            if (post.equals("ing")) sb1.insert(0, "to actively ");
            if (post.equals("ize")) sb1.insert(0, "change into ");
            if (post.equals("tion")) sb1 = new StringBuilder("the process of " + sb1 + "ing");
            if (post.equals("ful")) sb1.insert(0, "full of ");
        }
        StringBuilder sb2 = new StringBuilder(sb1.toString());
        for (String prev : prevs) {
            if (prev.equals("anti")) sb2.insert(0, "against ");
            if (prev.equals("post")) sb2.insert(0, "after ");
            if (prev.equals("pre")) sb2.insert(0, "before ");
            if (prev.equals("re")) sb2.append(" again");
            if (prev.equals("un")) sb2.insert(0, "not ");
        }
        word = sb2.toString();
        return word;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _word;
        try {
            _word = in.nextLine();
        } catch (Exception e) {
            _word = null;
        }

        res = unwangdulize(_word);
        System.out.println(res);
    }
}
