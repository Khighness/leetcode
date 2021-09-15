package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2020-09-22
 * @apiNote 1431. 拥有最多糖果的孩子
 */
public class T1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max =  0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> becomeMax = new ArrayList<>();
        for (int candy : candies) {
            becomeMax.add(candy + extraCandies >= max);
        }
        return becomeMax;
    }

}
