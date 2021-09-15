package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-06-16
 * @apiNote 824. 山羊拉丁文
 */
public class T824 {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char c = Character.toLowerCase(word.charAt(0));
            if (!(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) {
                word = word.substring(1) + word.charAt(0);
            }
            StringBuilder builder = new StringBuilder(word).append("ma");
            for (int k = 0; k <= i; k++) {
                builder.append('a');
            }
            words[i] = builder.toString();
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            ans.append(words[i]).append(" ");
        }
        return ans.append(words[words.length - 1]).toString();
    }

}
