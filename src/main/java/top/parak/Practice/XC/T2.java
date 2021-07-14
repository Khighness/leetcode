package top.parak.Practice.XC;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author KHighness
 * @since 2021-06-10
 */

public class T2 {
    static int collide(int[] numbers) {
        Arrays.sort(numbers);
        return 0;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] stringArray = str.split("\\,");
        int[] numbers = new int[stringArray.length];
        for(int i=0;i<stringArray.length;i++){
            numbers[i] = Integer.parseInt(stringArray[i]);
        }

        int res = collide(numbers);
        System.out.println(String.valueOf(res));
    }
}

