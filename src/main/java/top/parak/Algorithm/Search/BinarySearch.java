package top.parak.Algorithm.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KHighness
 * @since 2021-03-11
 * @apiNote 二分查找
 */
public class BinarySearch {

    /**
     * 循环
     */
    public static int search(int[] array, int value) {
        int left = 0;
        int right = array.length - 1;
        if (left > right || value < array[left] || value > array[right]) {
            throw new RuntimeException("Not Found");
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = array[mid];
            if (midVal == value) {
                return mid;
            } else if (midVal > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        throw new RuntimeException("Not Found");
    }

    /**
     * 递归
     */
    public static int search(int[] array, int left, int right, int value) {
        if (left > right || value < array[left] || value > array[right]) {
            throw new RuntimeException("Not Found");
        }
        int mid = (left + right) / 2;
        int midVal = array[mid];
        if (midVal == value) {
            return mid;
        } else if (midVal > value) {
            return search(array, left, mid - 1, value);
        } else {
            return search(array, mid + 1, right, value);
        }
    }

    /**
     * 查找所有下标
     */
    public static List<Integer> searchPlus(int[] array, int left, int right, int value)  {
        if (left > right || value < array[left] || value > array[right]) {
            throw new RuntimeException("Not Found");
        }
        List<Integer> list = new ArrayList<>();
        int mid = (left + right) / 2;
        int midVal = array[mid];
        if (midVal == value) {
            list.add(mid);
            // 向左扫描
            int temp = mid - 1;
            while (true) {
                if (temp == 0 || array[temp] != value) {
                    break;
                }
                list.add(temp--);
            }
            // 向右扫描
            temp = mid + 1;
            while (true) {
                if (temp == array.length - 1 || array[temp] != value) {
                    break;
                }
                list.add(temp++);
            }
        } else if (midVal > value) {
            return searchPlus(array, left, mid - 1, value);
        } else {
            return searchPlus(array, mid + 1, right, value);
        }
        return list;
    }

    public static void main(String[] args) {
        int array[] = {1, 8, 10, 99, 99, 99, 99, 99, 1000, 1234};
        System.out.println(search(array, 1));
        System.out.println(search(array, 0, array.length - 1, 99));
        searchPlus(array, 0, array.length - 1, 99).stream().forEach(System.out::println);
    }

}
