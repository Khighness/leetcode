package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/10/2 1:20
 * @apiNote 1237. 找出给定方程的正整数解
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 给出一个函数  f(x, y) 和一个目标结果 z，请你计算方程 f(x,y) == z 所有可能的正整数 数对 x 和 y。
 * 给定函数是严格单调的，也就是说：
 * f(x, y) < f(x + 1, y)
 * f(x, y) < f(x, y + 1)
 * 函数接口定义如下：
 *
 * interface CustomFunction {
 * public:
 *   // Returns positive integer f(x, y) for any given positive integer x and y.
 *   int f(int x, int y);
 * };
 * 如果你想自定义测试，你可以输入整数 function_id 和一个目标结果 z 作为输入，其中 function_id 表示一个隐藏函数列表中的一个函数编号，题目只会告诉你列表中的 2 个函数。  
 */
public class T1237 {
     class CustomFunction {
         // Returns f(x, y) for any given positive integers x and y.
         // Note that f(x, y) is increasing with respect to both x and y.
         // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
         // public int f(int x, int y);
     }

//    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 1; i <= 1000; i++) {
//            if (customfunction.f(i,1) > z) {
//                break;
//            }
//            for (int j = 1; j <= 1000; j++) {
//                if (customfunction.f(i,j) == z) {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    list.add(j);
//                    res.add(list);
//                    break;
//                } else if(customfunction.f(i,j) > z){
//                    break;
//                }
//            }
//        }
//        return res;
//    }

}
